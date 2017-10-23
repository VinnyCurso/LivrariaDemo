/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.business;

import br.com.livrariademo.dao.LivroDao;
import br.com.livrariademo.model.Livro;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author vinicius caetano
 */
public class LivroBusiness {

    LivroDao dao;

    public LivroBusiness() throws SQLException {
        dao = new LivroDao();
    }

    public void Salvar(Livro livro) throws SQLException, Exception {

        if (validar(livro)) {
            if (livro.getCodigo() == 0) {
                dao.Cadastrar(livro);
            } else {
                dao.Atualizar(livro);
            }
        }
    }

    public void Excluir(int codigo) throws SQLException, Exception {
        dao.Deletar(codigo);
    }

    public Livro Consultar(int codigo) throws SQLException {
        return dao.Consultar(codigo);
    }

    public List<Livro> listar(String nome) throws SQLException {
        return dao.Listar();
    }

    private boolean validar(Livro livro) throws Exception {

        if (livro.getNome() == null) {
            throw new Exception("É necessário preencher o campo nome.");
        }
        if (livro.getNome().isEmpty()) {
            throw new Exception("É necessário preencher o campo nome.");
        }

        if (livro.getDescricao() == null) {
            throw new Exception("É necessário preencher o campo descricao.");
        }
        if (livro.getDescricao().isEmpty()) {
            throw new Exception("É necessário preencher o campo descricao.");
        }

        if (livro.getNumeroPaginas() <= 0) {
            throw new Exception("É necessário preencher o campo Numero de Paginas corretamente.");
        }

        if (livro.getPreco() <= 0.0) {
            throw new Exception("É necessário preencher o campo Preço corretamente.");
        }

        if (livro.getPreco() <= 0.0) {
            throw new Exception("É necessário preencher o campo Peso corretamente.");
        }

        if (livro.getAvaliacao() <= 0) {
            throw new Exception("É necessário preencher o campo Avaliacao corretamente.");
        }

        if (livro.getIsbn() <= 0) {
            throw new Exception("É necessário preencher o campo Isbn corretamente.");
        }

        if (livro.getAltura() <= 0.0) {
            throw new Exception("É necessário preencher o campo Peso corretamente.");
        }

        if (livro.getLargura() <= 0.0) {
            throw new Exception("É necessário preencher o campo Peso corretamente.");
        }

        if (livro.getProfundidade() <= 0.0) {
            throw new Exception("É necessário preencher o campo Profundidade corretamente.");
        }

        if (livro.getQuantidadeEstoque() <= 0) {
            throw new Exception("É necessário preencher o campo Quantidade Estoque corretamente.");
        }

        if (livro.getCodigoBarras() == null) {
            throw new Exception("É necessário preencher o campo Codigo de Barras.");
        }
        if (livro.getCodigoBarras().isEmpty()) {
            throw new Exception("É necessário preencher o campo Codigo de Barras.");
        }

        return true;
    }

}
