/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.control;

import br.com.livrariademo.dao.IdiomaDao;
import br.com.livrariademo.model.Idioma;
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
public class IdiomaServlet extends HttpServlet {

     private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/Idioma.jsp";
    private static String LIST_IDIOMA = "/listIdioma.jsp";
    private IdiomaDao idiomaDAO;

    public IdiomaServlet() throws SQLException {
        super();
        idiomaDAO = new IdiomaDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            String forward = "";
            String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {

            int codigo = Integer.parseInt(request.getParameter("codigo"));
            idiomaDAO.Deletar(codigo);
            forward = LIST_IDIOMA;
            request.setAttribute("idiomaM", idiomaDAO.Listar());

        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int codigo = Integer.parseInt(request.getParameter("codigo"));

            Idioma idioma = idiomaDAO.Consultar(codigo);
            request.setAttribute("idioma", idioma);
        } else if (action.equalsIgnoreCase("listIdioma")) {
            forward = LIST_IDIOMA;
            request.setAttribute("idiomaM", idiomaDAO.Listar());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Idioma idioma = new Idioma();

        idioma.setDescricao(request.getParameter("descricao"));

        String codigo = request.getParameter("codigo");
        if (codigo == null || codigo.isEmpty()) {

            idiomaDAO.Cadastrar(idioma);
        } else {

            idioma.setCodigo(Integer.parseInt(codigo));
            idiomaDAO.Atualizar(idioma);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_IDIOMA);
        request.setAttribute("idiomaM", idiomaDAO.Listar());
        view.forward(request, response);
    }


}
