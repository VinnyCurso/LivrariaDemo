/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.control;

import br.com.livrariademo.dao.EditoraDao;
import br.com.livrariademo.model.Editora;
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
public class EditoraServlet extends HttpServlet {

   private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/Editora.jsp";
    private static String LIST_EDITORA = "/listEditora.jsp";
    private EditoraDao editoraDAO;

    public EditoraServlet() throws SQLException {
        super();
        editoraDAO = new EditoraDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            String forward = "";
            String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {

            int codigo = Integer.parseInt(request.getParameter("codigo"));
            editoraDAO.Deletar(codigo);
            forward = LIST_EDITORA;
            request.setAttribute("editoraM", editoraDAO.Listar());

        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int codigo = Integer.parseInt(request.getParameter("codigo"));

            Editora editora = editoraDAO.Consultar(codigo);
            request.setAttribute("editora", editora);
        } else if (action.equalsIgnoreCase("listEditora")) {
            forward = LIST_EDITORA;
            request.setAttribute("editoraM", editoraDAO.Listar());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Editora editora = new Editora();

        editora.setDescricao(request.getParameter("descricao"));

        String codigo = request.getParameter("codigo");
        if (codigo == null || codigo.isEmpty()) {

            editoraDAO.Cadastrar(editora);
        } else {

            editora.setCodigo(Integer.parseInt(codigo));
            editoraDAO.Atualizar(editora);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_EDITORA);
        request.setAttribute("editoraM", editoraDAO.Listar());
        view.forward(request, response);
    }


}
