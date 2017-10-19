/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.business;

import br.com.livrariademo.dao.AutorDao;
import br.com.livrariademo.model.Autor;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author vinicius caetano
 */
public class AutorBusiness {

    AutorDao dao;

    public AutorBusiness() throws SQLException {
        dao = new AutorDao();
    }

    public void Salvar(Autor autor) throws SQLException, Exception {

        if (validar(autor)) {
            if (autor.getCodigo() == 0) {
                dao.Cadastrar(autor);
            } else {
                dao.Atualizar(autor);
            }
        }
    }

    public void Excluir(int codigo) throws SQLException, Exception {
        dao.Deletar(codigo);
    }

    public Autor Consultar(int codigo) throws SQLException {
        return dao.Consultar(codigo);
    }

    public List<Autor> listar(String descricao) throws SQLException {
        return dao.Listar();
    }

    private boolean validar(Autor autor) throws Exception {
        if (autor.getDescricao() == null) {
            throw new Exception("É necessário preencher o campo descricao.");
        }
        if (autor.getDescricao().isEmpty()) {
            throw new Exception("É necessário preencher o campo descricao.");
        }
        return true;
    }

}
