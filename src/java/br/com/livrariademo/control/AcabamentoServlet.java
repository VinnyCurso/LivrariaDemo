/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.control;

import br.com.livrariademo.dao.AcabamentoLivroDao;
import br.com.livrariademo.model.AcabamentoLivro;
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
public class AcabamentoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/Acabamento.jsp";
    private static String LIST_ACABAMENTO = "/listAcabamento.jsp";
    private AcabamentoLivroDao acabamentoDAO;

    public AcabamentoServlet() throws SQLException {
        super();
        acabamentoDAO = new AcabamentoLivroDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            String forward = "";
            String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {

            int codigo = Integer.parseInt(request.getParameter("codigo"));
            acabamentoDAO.Deletar(codigo);
            forward = LIST_ACABAMENTO;
            request.setAttribute("acabamentoM", acabamentoDAO.Listar());

        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int codigo = Integer.parseInt(request.getParameter("codigo"));

            AcabamentoLivro acabamento = acabamentoDAO.Consultar(codigo);
            request.setAttribute("acabamento", acabamento);
        } else if (action.equalsIgnoreCase("listAcabamento")) {
            forward = LIST_ACABAMENTO;
            request.setAttribute("acabamentoM", acabamentoDAO.Listar());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AcabamentoLivro acabamento = new AcabamentoLivro();

        acabamento.setDescricao(request.getParameter("descricao"));

        String codigo = request.getParameter("codigo");
        if (codigo == null || codigo.isEmpty()) {

            acabamentoDAO.Cadastrar(acabamento);
        } else {

            acabamento.setCodigo(Integer.parseInt(codigo));
            acabamentoDAO.Atualizar(acabamento);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_ACABAMENTO);
        request.setAttribute("acabamentoM", acabamentoDAO.Listar());
        view.forward(request, response);
    }

}
