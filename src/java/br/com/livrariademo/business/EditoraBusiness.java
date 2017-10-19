/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.business;


import br.com.livrariademo.dao.EditoraDao;
import br.com.livrariademo.model.Editora;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author vinicius caetano
 */
public class EditoraBusiness {
    
    EditoraDao dao;

    public EditoraBusiness() throws SQLException {
        dao = new EditoraDao();
    }

    public void Salvar(Editora editora) throws SQLException, Exception {

        if (validar(editora)) {
            if (editora.getCodigo() == 0) {
                dao.Cadastrar(editora);
            } else {
                dao.Atualizar(editora);
            }
        }
    }

    public void Excluir(int codigo) throws SQLException, Exception {
        dao.Deletar(codigo);
    }

    public Editora Consultar(int codigo) throws SQLException {
        return dao.Consultar(codigo);
    }

    public List<Editora> listar(String descricao) throws SQLException {
        return dao.Listar();
    }

    private boolean validar(Editora editora) throws Exception {
        if (editora.getDescricao() == null) {
            throw new Exception("É necessário preencher o campo descricao.");
        }
        if (editora.getDescricao().isEmpty()) {
            throw new Exception("É necessário preencher o campo descricao.");
        }
        return true;
    }

    
}
