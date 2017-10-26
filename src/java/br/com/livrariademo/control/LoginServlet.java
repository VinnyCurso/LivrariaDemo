/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.control;

import br.com.livrariademo.dao.LoginDao;
import br.com.livrariademo.model.Login;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author vinicius caetano
 */
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private LoginDao loginDAO;
    
  
public LoginServlet() throws SQLException{
    super();
    loginDAO = new LoginDao();
}


  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
 
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
        
        Login loginE = new Login();
        
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String status = "";
       
            if(loginDAO.validarLogin(login, senha)){
                HttpSession sessao = request.getSession();
                sessao.setAttribute("sessaoUsuario", login);
                RequestDispatcher dispatcher = request.getRequestDispatcher("Home.jsp");
                dispatcher.forward(request, response);
                
            }else{
                request.setAttribute("mensagem", "Usuario/senha invalidos");
                RequestDispatcher dispatcher = request.getRequestDispatcher("LoginAutenticacao.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(null, "Erro"+ex.getMessage());
        }
       
    }

   
}
