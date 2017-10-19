/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.control;


import br.com.livrariademo.dao.ClienteDao;
import br.com.livrariademo.model.Cliente;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vinicius caetano
 */
public class ClienteServlet extends HttpServlet {

   private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/Cliente.jsp";
    private static String LIST_CLIENTE = "/listCliente.jsp";
    private ClienteDao ClienteDAO;

    public ClienteServlet() throws SQLException {
        super();
        ClienteDAO = new ClienteDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            String forward = "";
            String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {

            int codigo = Integer.parseInt(request.getParameter("codigo"));
            ClienteDAO.Deletar(codigo);
            forward = LIST_CLIENTE;
            request.setAttribute("clienteM", ClienteDAO.Listar());

        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int codigo = Integer.parseInt(request.getParameter("codigo"));

            Cliente cliente = ClienteDAO.Consultar(codigo);
            request.setAttribute("cliente", cliente);
        } else if (action.equalsIgnoreCase("listCliente")) {
            forward = LIST_CLIENTE;
            request.setAttribute("clienteM", ClienteDAO.Listar());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cliente cliente = new Cliente();

        cliente.setNome(request.getParameter("nome"));
        cliente.setEmail(request.getParameter("email"));
        cliente.setTelefone(request.getParameter("telefone"));
        cliente.setCpf(Long.parseLong(request.getParameter("cpf")));
        try {
            Date dataCadastro = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("dataCadastro"));
            cliente.setDataCadastro(dataCadastro);
        } catch (ParseException e) {
            e.getMessage();
        }

        String codigo = request.getParameter("codigo");
        if (codigo == null || codigo.isEmpty()) {

            ClienteDAO.Cadastrar(cliente);
        } else {

            cliente.setCodigo(Integer.parseInt(codigo));
            ClienteDAO.Atualizar(cliente);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_CLIENTE);
        request.setAttribute("clienteM", ClienteDAO.Listar());
        view.forward(request, response);
    }


}
