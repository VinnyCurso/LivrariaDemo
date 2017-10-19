/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.business;

import br.com.livrariademo.dao.IdiomaDao;
import br.com.livrariademo.model.Idioma;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author vinicius caetano
 */
public class IdiomaBusiness {
    
     IdiomaDao dao;

    public IdiomaBusiness() throws SQLException {
        dao = new IdiomaDao();
    }

    public void Salvar(Idioma idioma) throws SQLException, Exception {

        if (validar(idioma)) {
            if (idioma.getCodigo() == 0) {
                dao.Cadastrar(idioma);
            } else {
                dao.Atualizar(idioma);
            }
        }
    }

    public void Excluir(int codigo) throws SQLException, Exception {
        dao.Deletar(codigo);
    }

    public Idioma Consultar(int codigo) throws SQLException {
        return dao.Consultar(codigo);
    }

    public List<Idioma> listar(String descricao) throws SQLException {
        return dao.Listar();
    }

    private boolean validar(Idioma idioma) throws Exception {
        if (idioma.getDescricao() == null) {
            throw new Exception("É necessário preencher o campo descricao.");
        }
        if (idioma.getDescricao().isEmpty()) {
            throw new Exception("É necessário preencher o campo descricao.");
        }
        return true;
    }
    
}
