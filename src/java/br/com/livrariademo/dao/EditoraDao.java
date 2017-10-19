/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.dao;

import br.com.livrariademo.model.Editora;
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
public class EditoraDao {
    
    private Connection connection;

    public EditoraDao() throws SQLException {
        connection = ConexaoBD.getConnection();
    }

    public void Cadastrar(Editora editora) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into editora (ddescricao) values (?)");

            preparedStatement.setString(1, editora.getDescricao());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Deletar(int codigo) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from editora where cod_editora=?");

            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Atualizar(Editora editora) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update editora set ddescricao=?"
                            + "where cod_editora=?");

            preparedStatement.setString(1, editora.getDescricao());

            preparedStatement.setInt(2, editora.getCodigo());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public List<Editora> Listar() {
        List<Editora> editoraM = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from editora");
            while (rs.next()) {

                Editora editora = new Editora();

                editora.setCodigo(rs.getInt("cod_editora"));
                editora.setDescricao(rs.getString("ddescricao"));

                editoraM.add(editora);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return editoraM;
    }

    public Editora Consultar(int codigo) {
        Editora editora = new Editora();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from editora where cod_editora=?");
            preparedStatement.setInt(1, codigo);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

                editora.setCodigo(rs.getInt("cod_editora"));
                editora.setDescricao(rs.getString("ddescricao"));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return editora;
    }
    
    public Editora ConsultarPorCodigo(int codigo) {
		Editora editora = new Editora();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from editora where cod_editora=?");
			preparedStatement.setInt(1, codigo);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				editora.setCodigo(rs.getInt("cod_editora"));
                                editora.setDescricao(rs.getString("ddescricao"));
                        }
                        
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
		}

		return editora;
	}

    
}
