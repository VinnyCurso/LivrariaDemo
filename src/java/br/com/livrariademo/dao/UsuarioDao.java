/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.dao;

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
public class UsuarioDao {
    
     private Connection connection;

    public UsuarioDao() throws SQLException {
        connection = ConexaoBD.getConnection();
    }

    public void Cadastrar(Usuario usuario) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into usuario (dlogin, dpassword, dconfirmacaopassword, dname, dativo) values (?,?,?,?,?)");

            preparedStatement.setString(1, usuario.getLogin());
            preparedStatement.setString(2, usuario.getPassword());
            preparedStatement.setString(3, usuario.getConfirmacaoPassword());
            preparedStatement.setString(4, usuario.getName());
            preparedStatement.setInt(5, usuario.getAtivo());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Deletar(int codigo) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from usuario where cod_usuario=?");

            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Atualizar(Usuario usuario) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update idioma set dlogin=?, dpassword=? , dconfirmacaopassword=?, dname=? , dativo=?"
                            + "where cod_usuario=?");

             preparedStatement.setString(1, usuario.getLogin());
            preparedStatement.setString(2, usuario.getPassword());
            preparedStatement.setString(3, usuario.getConfirmacaoPassword());
            preparedStatement.setString(4, usuario.getName());
            preparedStatement.setInt(5, usuario.getAtivo());

            preparedStatement.setInt(6, usuario.getCodigo());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public List<Usuario> Listar() {
        List<Usuario> usuarioM = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from usuario");
            while (rs.next()) {

                Usuario usuario = new Usuario();

                usuario.setCodigo(rs.getInt("cod_usuario"));
                usuario.setLogin(rs.getString("dlogin"));
                usuario.setPassword(rs.getString("dpassword"));
                usuario.setConfirmacaoPassword(rs.getString("dconfirmacaopassword"));
                usuario.setName(rs.getString("dname"));
                usuario.setAtivo(Integer.parseInt(rs.getString("dativo")));

                usuarioM.add(usuario);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return usuarioM;
    }

    public Usuario Consultar(int codigo) {
        Usuario usuario = new Usuario();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from usuario where cod_usuario=?");
            preparedStatement.setInt(1, codigo);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

                usuario.setCodigo(rs.getInt("cod_usuario"));
                usuario.setLogin(rs.getString("dlogin"));
                usuario.setPassword(rs.getString("dpassword"));
                usuario.setConfirmacaoPassword(rs.getString("dconfirmacaopassword"));
                usuario.setName(rs.getString("dname"));
                usuario.setAtivo(Integer.parseInt(rs.getString("dativo")));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return usuario;
    }
    
    public Usuario ConsultarPorCodigo(int codigo) {
		Usuario usuario = new Usuario();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from usuario where cod_usuario=?");
			preparedStatement.setInt(1, codigo);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
		
                usuario.setCodigo(rs.getInt("cod_usuario"));
                usuario.setLogin(rs.getString("dlogin"));
                usuario.setPassword(rs.getString("dpassword"));
                usuario.setConfirmacaoPassword(rs.getString("dconfirmacaopassword"));
                usuario.setName(rs.getString("dname"));
                usuario.setAtivo(Integer.parseInt(rs.getString("dativo")));
                        }
                        
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
		}

		return usuario;
	}

    
    
    
}
