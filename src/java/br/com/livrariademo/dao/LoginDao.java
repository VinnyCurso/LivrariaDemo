/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.dao;

import br.com.livrariademo.model.Login;
import br.com.livrariademo.model.Usuario;
import br.com.livrariademo.util.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author vinicius caetano
 */
public class LoginDao {
    
     private Connection connection;

    public LoginDao() throws SQLException {
        connection = ConexaoBD.getConnection();
    }
    
    public boolean validarLogin(String login, String senha) throws Exception{
         
        try {
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from usuario where dlogin = '"+ login +"' and dpassword = '"+ senha+"'");
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
              return true; //Possui usuario
            }else{
                  return false; //Nao possui usuario
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
        return false; 
    }
    
     public void Cadastrar(Login login) {

        try {
            PreparedStatement preparedStatement = connection
            .prepareStatement("insert into login (login,senha) values (?,?)");

            preparedStatement.setString(1, login.getLogin());
            preparedStatement.setString(2, login.getSenha());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Deletar(int codigo) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from login where cod_login=?");

            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Atualizar(Usuario usuario) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update usuario set login=?, senha=? "
                            + "where cod_login=?");

            preparedStatement.setString(1, usuario.getLogin());
            preparedStatement.setString(2, usuario.getPassword());

            preparedStatement.setInt(3, usuario.getCodigo());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public List<Login> Listar() {
        List<Login> LoginList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from login");
            while (rs.next()) {

                Login login = new Login();

                login.setCodigo(rs.getInt("cod_login"));
                login.setLogin(rs.getString("login"));
                login.setSenha(rs.getString("senha"));

                LoginList.add(login);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return LoginList;
    }

    public Login Consultar(int codigo) {
        Login login = new Login();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from login where cod_login=?");
            preparedStatement.setInt(1, codigo);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

                login.setCodigo(rs.getInt("cod_login"));
                login.setLogin(rs.getString("login"));
                login.setSenha(rs.getString("senha"));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return login;
    }
    
    public Login ConsultarPorCodigo(int codigo) {
		Login login = new Login();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from login where cod_login=?");
			preparedStatement.setInt(1, codigo);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
                            
		login.setLogin(rs.getString("login"));
                login.setSenha(rs.getString("senha"));
                        }
                        
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
		}

		return login;
	}   
    
    
}
