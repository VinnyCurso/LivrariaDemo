/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.dao;

import br.com.livrariademo.model.Idioma;
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
public class IdiomaDao {
    
     private Connection connection;

    public IdiomaDao() throws SQLException {
        connection = ConexaoBD.getConnection();
    }

    public void Cadastrar(Idioma idioma) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into idioma (ddescricao) values (?)");

            preparedStatement.setString(1, idioma.getDescricao());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Deletar(int codigo) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from idioma where cod_idioma=?");

            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Atualizar(Idioma idioma) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update idioma set ddescricao=?"
                            + "where cod_idioma=?");

            preparedStatement.setString(1, idioma.getDescricao());

            preparedStatement.setInt(2, idioma.getCodigo());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public List<Idioma> Listar() {
        List<Idioma> idiomaM = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from idioma");
            while (rs.next()) {

                Idioma idioma = new Idioma();

                idioma.setCodigo(rs.getInt("cod_idioma"));
                idioma.setDescricao(rs.getString("ddescricao"));

                idiomaM.add(idioma);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return idiomaM;
    }

    public Idioma Consultar(int codigo) {
        Idioma idioma = new Idioma();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from idioma where cod_idioma=?");
            preparedStatement.setInt(1, codigo);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

                idioma.setCodigo(rs.getInt("cod_idioma"));
                idioma.setDescricao(rs.getString("ddescricao"));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return idioma;
    }
    
    public Idioma ConsultarPorCodigo(int codigo) {
		Idioma idioma = new Idioma();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from idioma where cod_idioma=?");
			preparedStatement.setInt(1, codigo);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				idioma.setCodigo(rs.getInt("cod_idioma"));
                                idioma.setDescricao(rs.getString("ddescricao"));
                        }
                        
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
		}

		return idioma;
	}

    
    
}
