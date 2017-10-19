/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.business;

import br.com.livrariademo.dao.AcabamentoLivroDao;
import br.com.livrariademo.model.AcabamentoLivro;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author vinicius caetano
 */
public class AcabamentoLivroBusiness {

    AcabamentoLivroDao dao;

    public AcabamentoLivroBusiness() throws SQLException {
        dao = new AcabamentoLivroDao();
    }

    public void Salvar(AcabamentoLivro acabamento) throws SQLException, Exception {
    
         if (validar(acabamento)) {
            if (acabamento.getCodigo() == 0) {
                 dao.Cadastrar(acabamento);
            } else {
               dao.Atualizar(acabamento);
            }
}
    }

    public void Excluir(int codigo) throws SQLException, Exception {
        dao.Deletar(codigo);
    }

    public AcabamentoLivro Consultar(int codigo) throws SQLException {
        return dao.Consultar(codigo);
    }

    public List<AcabamentoLivro> listar(String descricao) throws SQLException {
        return dao.Listar();
    }
    
     private boolean validar(AcabamentoLivro acabamento) throws Exception {
        if (acabamento.getDescricao() == null) {
            throw new Exception("É necessário preencher o campo descricao.");
}
     if (acabamento.getDescricao().isEmpty()) {
            throw new Exception("É necessário preencher o campo nome.");
}
        return true;
     }

}
