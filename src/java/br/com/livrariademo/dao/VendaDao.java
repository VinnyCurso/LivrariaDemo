/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.dao;

import br.com.livrariademo.enums.TipoPagamento;
import br.com.livrariademo.model.Cliente;
import br.com.livrariademo.model.Usuario;
import br.com.livrariademo.model.Venda;
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
public class VendaDao {
    
     private Connection connection;

    public VendaDao() throws SQLException {
        connection = ConexaoBD.getConnection();
    }

    public void Cadastrar(Venda venda) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into venda (codigocliente, codigousuario, dvalortotal, dtipopagamento) values (?,?,?,?)");

            preparedStatement.setInt(1, venda.getCliente().getCodigo());
            preparedStatement.setInt(2, venda.getUsuario().getCodigo());
            preparedStatement.setDouble(3, venda.getValorTotal());
            preparedStatement.setObject(4, venda.getTipoPagamento());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Deletar(int codigo) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from venda where cod_venda=?");

            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Atualizar(Venda venda) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update venda set codigocliente=?, codigousuario=? , dvalortotal=?, dtipopagamento=?"
                            + "where cod_venda=?");

            preparedStatement.setInt(1, venda.getCliente().getCodigo());
            preparedStatement.setInt(2, venda.getUsuario().getCodigo());
            preparedStatement.setDouble(3, venda.getValorTotal());
            preparedStatement.setObject(4, venda.getTipoPagamento());

            preparedStatement.setInt(5, venda.getCodigo());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public List<Venda> Listar() {
        List<Venda> vendaM = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from venda");
            while (rs.next()) {

                Venda venda = new Venda();

                venda.setCodigo(rs.getInt("cod_venda"));
                venda.setCliente((Cliente)rs.getObject("codigocliente"));
                    venda.setUsuario((Usuario)rs.getObject("codigousuario"));
                venda.setValorTotal(Double.parseDouble((String) rs.getObject("dvalortotal")));
//                venda.setTipoPagamento((TipoPagamento.valueOf(enumType, rs.getObject("dtipopagamento"))));

                vendaM.add(venda);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return vendaM;
    }

    public Venda Consultar(int codigo) {
        Venda venda = new Venda();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from venda where cod_venda=?");
            preparedStatement.setInt(1, codigo);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

                venda.setCodigo(rs.getInt("cod_venda"));
                venda.setCliente((Cliente)rs.getObject("codigocliente"));
                venda.setUsuario((Usuario)rs.getObject("codigousuario"));
                venda.setValorTotal(Double.parseDouble((String) rs.getObject("dvalortotal")));
//                venda.setTipoPagamento((TipoPagamento.valueOf(enumType, rs.getObject("dtipopagamento"))));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return venda;
    }
    
    public Venda ConsultarPorCodigo(int codigo) {
		Venda venda = new Venda();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from venda where cod_venda=?");
			preparedStatement.setInt(1, codigo);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				       
                        venda.setCodigo(rs.getInt("cod_venda"));
                        venda.setCliente((Cliente) rs.getObject("codigocliente"));
                        venda.setUsuario((Usuario) rs.getObject("codigousuario"));
                        venda.setValorTotal(Double.parseDouble((String) rs.getObject("dvalortotal")));
//                venda.setTipoPagamento((TipoPagamento.valueOf(enumType, rs.getObject("dtipopagamento"))));
                    }
                        
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
		}

		return venda;
	}

    
    
}
