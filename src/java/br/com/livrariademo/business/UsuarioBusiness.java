/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.business;

import br.com.livrariademo.dao.AutorDao;
import br.com.livrariademo.dao.UsuarioDao;
import br.com.livrariademo.model.Autor;
import br.com.livrariademo.model.Usuario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author vinicius caetano
 */
public class UsuarioBusiness {
    
     UsuarioDao dao;

    public UsuarioBusiness() throws SQLException {
        dao = new UsuarioDao();
    }

    public void Salvar(Usuario usuario) throws SQLException, Exception {

        if (validar(usuario)) {
            if (usuario.getCodigo() == 0) {
                dao.Cadastrar(usuario);
            } else {
                dao.Atualizar(usuario);
            }
        }
    }

    public void Excluir(int codigo) throws SQLException, Exception {
        dao.Deletar(codigo);
    }

    public Usuario Consultar(int codigo) throws SQLException {
        return dao.Consultar(codigo);
    }

    public List<Usuario> listar(String descricao) throws SQLException {
        return dao.Listar();
    }

    private boolean validar(Usuario usuario) throws Exception {
        if (usuario.getLogin() == null) {
            throw new Exception("É necessário preencher o campo login.");
        }
        if (usuario.getLogin().isEmpty()) {
            throw new Exception("É necessário preencher o campo login.");
        }
        
         if (usuario.getPassword() == null) {
            throw new Exception("É necessário preencher o campo Password.");
        }
        if (usuario.getPassword().isEmpty()) {
            throw new Exception("É necessário preencher o campo Password.");
        }
        
          if (usuario.getConfirmacaoPassword()== null) {
            throw new Exception("É necessário preencher o campo Confirmacao Password.");
        }
        if (usuario.getConfirmacaoPassword().isEmpty()) {
            throw new Exception("É necessário preencher o campo Confirmacao Password.");
        }
        
//          if (usuario.getName()== null) {
//            throw new Exception("É necessário preencher o campo Name.");
//        }
//        if (usuario.getName().isEmpty()) {
//            throw new Exception("É necessário preencher o campo Name.");
//        }
        
        return true;
    }

    
}
