/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.control;

import br.com.livrariademo.dao.UsuarioDao;
import br.com.livrariademo.model.Autor;
import br.com.livrariademo.model.Usuario;
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
public class UsuarioServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/Usuario.jsp";
    private static String LIST_USUARIO = "/listUsuario.jsp";
    private UsuarioDao usuarioDAO;

    public UsuarioServlet() throws SQLException {
        super();
        usuarioDAO = new UsuarioDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            String forward = "";
            String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {

            int codigo = Integer.parseInt(request.getParameter("codigo"));
            usuarioDAO.Deletar(codigo);
            forward = LIST_USUARIO;
            request.setAttribute("usuarioM", usuarioDAO.Listar());

        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int codigo = Integer.parseInt(request.getParameter("codigo"));

            Usuario usuario = usuarioDAO.Consultar(codigo);
            request.setAttribute("usuario", usuario);
        } else if (action.equalsIgnoreCase("listUsuario")) {
            forward = LIST_USUARIO;
            request.setAttribute("usuarioM", usuarioDAO.Listar());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Usuario usuario = new Usuario();

        usuario.setLogin(request.getParameter("login"));
        usuario.setLogin(request.getParameter("password"));
        usuario.setLogin(request.getParameter("confirmacaoPassword"));
        usuario.setLogin(request.getParameter("name"));
        usuario.setLogin(request.getParameter("ativo"));

       
        String codigo = request.getParameter("codigo");
        if (codigo == null || codigo.isEmpty()) {

            usuarioDAO.Cadastrar(usuario);
        } else {

            usuario.setCodigo(Integer.parseInt(codigo));
            usuarioDAO.Atualizar(usuario);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_USUARIO);
        request.setAttribute("usuariorM", usuarioDAO.Listar());
        view.forward(request, response);
    }

}
