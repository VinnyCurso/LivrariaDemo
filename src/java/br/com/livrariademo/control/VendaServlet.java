/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.control;


import br.com.livrariademo.dao.ClienteDao;
import br.com.livrariademo.dao.UsuarioDao;
import br.com.livrariademo.dao.VendaDao;
import br.com.livrariademo.enums.TipoPagamento;
import br.com.livrariademo.model.Cliente;
import br.com.livrariademo.model.Usuario;
import br.com.livrariademo.model.Venda;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vinicius caetano
 */
public class VendaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/Venda.jsp";
    private static String LIST_VENDA = "/listVenda.jsp";
    private VendaDao vendaDAO;
    
    private ClienteDao clienteDAO;
    private UsuarioDao usuarioDAO;

    
    
     public VendaServlet() throws SQLException {
        super();
        
        vendaDAO = new VendaDao();
        clienteDAO = new ClienteDao();
        usuarioDAO = new UsuarioDao();

    }
     
      @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            String forward = "";
            String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {

            int codigo = Integer.parseInt(request.getParameter("codigo"));
            vendaDAO.Deletar(codigo);
            forward = LIST_VENDA;
            request.setAttribute("vendaM", vendaDAO.Listar());

        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int codigo = Integer.parseInt(request.getParameter("codigo"));

            Venda venda = vendaDAO.Consultar(codigo);
            request.setAttribute("venda", venda);
        } else if (action.equalsIgnoreCase("listVenda")) {
            forward = LIST_VENDA;
            request.setAttribute("vendaM", vendaDAO.Listar());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
//            request.setAttribute("vendaM", vendaDAO.Listar());
            request.setAttribute("clienteM", clienteDAO.Listar());
            request.setAttribute("usuarioM", usuarioDAO.Listar());

            view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

        Venda venda = new Venda();
        
        venda.setCliente(new Cliente());
        venda.setUsuario(new Usuario());

        venda.setValorTotal(Double.parseDouble(request.getParameter("valorTotal")));
        venda.setTipoPagamento(TipoPagamento.DINHEIRO);
        venda.setTipoPagamento(TipoPagamento.CARTAO);

        
        
        String codigo = request.getParameter("codigo");
        if (codigo == null || codigo.isEmpty()) {

            vendaDAO.Cadastrar(venda);
        } else {

            venda.setCodigo(Integer.parseInt(codigo));
            vendaDAO.Atualizar(venda);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_VENDA);
        request.setAttribute("vendaM", vendaDAO.Listar());
        view.forward(request, response);
    }


}
