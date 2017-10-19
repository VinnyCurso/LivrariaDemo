/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.dao;

import br.com.livrariademo.model.Autor;
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
public class AutorDao {
    
     private Connection connection;

    public AutorDao() throws SQLException {
        connection = ConexaoBD.getConnection();
    }

    public void Cadastrar(Autor autor) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into autor (ddescricao) values (?)");

            preparedStatement.setString(1, autor.getDescricao());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Deletar(int codigo) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from autor where cod_autor=?");

            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Atualizar(Autor autor) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update autor set ddescricao=?"
                            + "where cod_autor=?");

            preparedStatement.setString(1, autor.getDescricao());

            preparedStatement.setInt(2, autor.getCodigo());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public List<Autor> Listar() {
        List<Autor> autorM = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from autor");
            while (rs.next()) {

                Autor autor = new Autor();

                autor.setCodigo(rs.getInt("cod_autor"));
                autor.setDescricao(rs.getString("ddescricao"));

                autorM.add(autor);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return autorM;
    }

    public Autor Consultar(int codigo) {
        Autor autor = new Autor();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from autor where cod_autor=?");
            preparedStatement.setInt(1, codigo);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

                autor.setCodigo(rs.getInt("cod_autor"));
                autor.setDescricao(rs.getString("ddescricao"));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return autor;
    }
    
    public Autor ConsultarPorCodigo(int codigo) {
		Autor autor = new Autor();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from autor where cod_autor=?");
			preparedStatement.setInt(1, codigo);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				autor.setCodigo(rs.getInt("cod_autor"));
                                autor.setDescricao(rs.getString("ddescricao"));
                        }
                        
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
		}

		return autor;
	}

    
}
