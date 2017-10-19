/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.business;

import br.com.livrariademo.dao.GeneroDao;
import br.com.livrariademo.model.Genero;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author vinicius caetano
 */
public class GeneroBusiness {
    
    GeneroDao dao;

    public GeneroBusiness() throws SQLException {
        dao = new GeneroDao();
    }

    public void Salvar(Genero genero) throws SQLException, Exception {

        if (validar(genero)) {
            if (genero.getCodigo() == 0) {
                dao.Cadastrar(genero);
            } else {
                dao.Atualizar(genero);
            }
        }
    }

    public void Excluir(int codigo) throws SQLException, Exception {
        dao.Deletar(codigo);
    }

    public Genero Consultar(int codigo) throws SQLException {
        return dao.Consultar(codigo);
    }

    public List<Genero> listar(String descricao) throws SQLException {
        return dao.Listar();
    }

    private boolean validar(Genero genero) throws Exception {
        if (genero.getDescricao() == null) {
            throw new Exception("É necessário preencher o campo descricao.");
        }
        if (genero.getDescricao().isEmpty()) {
            throw new Exception("É necessário preencher o campo descricao.");
        }
        return true;
    }

    
    
}
