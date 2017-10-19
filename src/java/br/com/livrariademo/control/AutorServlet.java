/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.control;

import br.com.livrariademo.dao.AutorDao;
import br.com.livrariademo.model.Autor;
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
public class AutorServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/Autor.jsp";
    private static String LIST_AUTOR = "/listAutor.jsp";
    private AutorDao autorDAO;

    public AutorServlet() throws SQLException {
        super();
        autorDAO = new AutorDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            String forward = "";
            String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {

            int codigo = Integer.parseInt(request.getParameter("codigo"));
            autorDAO.Deletar(codigo);
            forward = LIST_AUTOR;
            request.setAttribute("autorM", autorDAO.Listar());

        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int codigo = Integer.parseInt(request.getParameter("codigo"));

            Autor autor = autorDAO.Consultar(codigo);
            request.setAttribute("autor", autor);
        } else if (action.equalsIgnoreCase("listAutor")) {
            forward = LIST_AUTOR;
            request.setAttribute("autorM", autorDAO.Listar());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Autor autor = new Autor();

        autor.setDescricao(request.getParameter("descricao"));

        String codigo = request.getParameter("codigo");
        if (codigo == null || codigo.isEmpty()) {

            autorDAO.Cadastrar(autor);
        } else {

            autor.setCodigo(Integer.parseInt(codigo));
            autorDAO.Atualizar(autor);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_AUTOR);
        request.setAttribute("autorM", autorDAO.Listar());
        view.forward(request, response);
    }


}
