/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.business;

import br.com.livrariademo.dao.ClienteDao;
import br.com.livrariademo.model.Cliente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author vinicius caetano
 */
public class ClienteBusiness {

    ClienteDao dao;

    public ClienteBusiness() throws SQLException {
        dao = new ClienteDao();
    }

    public void Salvar(Cliente cliente) throws SQLException, Exception {

        if (validar(cliente)) {
            if (cliente.getCodigo() == 0) {
                dao.Cadastrar(cliente);
            } else {
                dao.Atualizar(cliente);
            }
        }
    }

    public void Excluir(int codigo) throws SQLException, Exception {
        dao.Deletar(codigo);
    }

    public Cliente Consultar(int codigo) throws SQLException {
        return dao.Consultar(codigo);
    }

    public List<Cliente> listar(String descricao) throws SQLException {
        return dao.Listar();
    }

    private boolean validar(Cliente cliente) throws Exception {
        if (cliente.getNome() == null) {
            throw new Exception("É necessário preencher o campo nome.");
        }
        if (cliente.getNome().isEmpty()) {
            throw new Exception("É necessário preencher o campo nome.");
        }

        if (cliente.getEmail() == null) {
            throw new Exception("É necessário preencher o campo email.");
        }
        if (cliente.getEmail().isEmpty()) {
            throw new Exception("É necessário preencher o campo email.");
        }

        if (cliente.getTelefone() == null) {
            throw new Exception("É necessário preencher o campo telefone.");
        }
        if (cliente.getTelefone().isEmpty()) {
            throw new Exception("É necessário preencher o campo telefone.");
        }

        if (cliente.getCpf() == null) {
            throw new Exception("É necessário preencher o campo CPF.");
        }

        if (cliente.getDataCadastro() == null) {
            throw new Exception("É necessário preencher o campo DataCadastro.");
        }

        return true;
    }

}
