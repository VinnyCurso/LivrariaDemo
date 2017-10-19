/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.dao;

import br.com.livrariademo.util.ConexaoBD;
import br.com.livrariademo.model.AcabamentoLivro;
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
public class AcabamentoLivroDao {

    private Connection connection;

    public AcabamentoLivroDao() throws SQLException {
        connection = ConexaoBD.getConnection();
    }

    public void Cadastrar(AcabamentoLivro acabamento) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into acabamento (ddescricao) values (?)");

            preparedStatement.setString(1, acabamento.getDescricao());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Deletar(int codigo) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from acabamento where cod_acabamento=?");

            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Atualizar(AcabamentoLivro acabamento) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update acabamento set ddescricao=?"
                            + "where cod_acabamento=?");

            preparedStatement.setString(1, acabamento.getDescricao());

            preparedStatement.setInt(2, acabamento.getCodigo());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public List<AcabamentoLivro> Listar() {
        List<AcabamentoLivro> acabamentoM = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from acabamento");
            while (rs.next()) {

                AcabamentoLivro acabamento = new AcabamentoLivro();

                acabamento.setCodigo(rs.getInt("cod_acabamento"));
                acabamento.setDescricao(rs.getString("ddescricao"));

                acabamentoM.add(acabamento);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return acabamentoM;
    }

    public AcabamentoLivro Consultar(int codigo) {
        AcabamentoLivro acabamento = new AcabamentoLivro();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from acabamento where cod_acabamento=?");
            preparedStatement.setInt(1, codigo);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

                acabamento.setCodigo(rs.getInt("cod_acabamento"));
                acabamento.setDescricao(rs.getString("ddescricao"));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return acabamento;
    }

}
