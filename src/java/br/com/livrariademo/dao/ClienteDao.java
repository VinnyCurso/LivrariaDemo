/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.dao;

import br.com.livrariademo.model.Cliente;
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
public class ClienteDao {
    
     private Connection connection;

    public ClienteDao() throws SQLException {
        connection = ConexaoBD.getConnection();
    }

    public void Cadastrar(Cliente cliente) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into cliente (dnome,demail,dtelefone,dcpf,ddatacadastro) values (?,?,?,?,?)");

            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getEmail());
            preparedStatement.setString(3, cliente.getTelefone());
            preparedStatement.setLong(4, cliente.getCpf());
            preparedStatement.setDate(5, new java.sql.Date(cliente.getDataCadastro().getTime()));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Deletar(int codigo) {
        try {
            PreparedStatement preparedStatement = connection
            .prepareStatement("delete from cliente where cod_cliente=?");

            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Atualizar(Cliente cliente) {

        try {
            PreparedStatement preparedStatement = connection
            .prepareStatement("update cliente set dnome=?, demail=?, dtelefone=?, dcpf=?, ddatacadastro=?"
                            + "where cod_cliente=?");

            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getEmail());
            preparedStatement.setString(3, cliente.getTelefone());
            preparedStatement.setLong(4, cliente.getCpf());
            preparedStatement.setDate(5, new java.sql.Date(cliente.getDataCadastro().getTime()));

            preparedStatement.setInt(6, cliente.getCodigo());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public List<Cliente> Listar() {
        List<Cliente> clienteM = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from cliente");
            while (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setCodigo(rs.getInt("cod_cliente"));
                cliente.setNome(rs.getString("dnome"));
                cliente.setEmail(rs.getString("demail"));
                cliente.setTelefone(rs.getString("dtelefone"));
                cliente.setCpf(rs.getLong("dcpf"));
                cliente.setDataCadastro(rs.getDate("ddatacadastro"));

                clienteM.add(cliente);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return clienteM;
    }

    public Cliente Consultar(int codigo) {
        Cliente cliente = new Cliente();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from cliente where cod_cliente=?");
            preparedStatement.setInt(1, codigo);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

               cliente.setCodigo(rs.getInt("cod_cliente"));
                cliente.setNome(rs.getString("dnome"));
                cliente.setEmail(rs.getString("demail"));
                cliente.setTelefone(rs.getString("dtelefone"));
                cliente.setCpf(rs.getLong("dcpf"));
                cliente.setDataCadastro(rs.getDate("ddatacadastro"));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return cliente;
    }
    
    public Cliente ConsultarPorCodigo(int codigo) {
		Cliente cliente = new Cliente();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from cliente where cod_cliente=?");
			preparedStatement.setInt(1, codigo);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
		
                cliente.setCodigo(rs.getInt("cod_cliente"));
                cliente.setNome(rs.getString("dnome"));
                cliente.setEmail(rs.getString("demail"));
                cliente.setTelefone(rs.getString("dtelefone"));
                cliente.setCpf(rs.getLong("dcpf"));
                cliente.setDataCadastro(rs.getDate("ddatacadastro"));
                        }
                        
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
		}

		return cliente;
	}

    
    
}
