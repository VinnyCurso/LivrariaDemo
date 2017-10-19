/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.control;

import br.com.livrariademo.dao.GeneroDao;
import br.com.livrariademo.model.Genero;
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
public class GeneroServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/Genero.jsp";
    private static String LIST_GENERO = "/listGenero.jsp";
    private GeneroDao generoDAO;
    

    public GeneroServlet() throws SQLException {
        super();
        generoDAO = new GeneroDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            String forward = "";
            String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {

            int codigo = Integer.parseInt(request.getParameter("codigo"));
            generoDAO.Deletar(codigo);
            forward = LIST_GENERO;
            request.setAttribute("generoM", generoDAO.Listar());

        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int codigo = Integer.parseInt(request.getParameter("codigo"));

            Genero genero = generoDAO.Consultar(codigo);
            request.setAttribute("genero", genero);
        } else if (action.equalsIgnoreCase("listGenero")) {
            forward = LIST_GENERO;
            request.setAttribute("generoM", generoDAO.Listar());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Genero genero = new Genero();

        genero.setDescricao(request.getParameter("descricao"));

        String codigo = request.getParameter("codigo");
        if (codigo == null || codigo.isEmpty()) {

            generoDAO.Cadastrar(genero);
        } else {

            genero.setCodigo(Integer.parseInt(codigo));
            generoDAO.Atualizar(genero);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_GENERO);
        request.setAttribute("generoM", generoDAO.Listar());
        view.forward(request, response);
    }


}
