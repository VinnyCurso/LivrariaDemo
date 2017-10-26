/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.padraoObserver;

import br.com.livrariademo.padraoObserver.Sujeito;
import br.com.livrariademo.padraoObserver.Observador;
import br.com.livrariademo.model.Livro;

/**
 *
 * @author vinicius caetano
 */
public class TesteLivroObsUm implements Observador {

    private Livro livro;
    private Sujeito CentralSystem;

    public TesteLivroObsUm(Sujeito CentralSystem) {
        this.CentralSystem = CentralSystem;
        this.CentralSystem.incluirObservador(this);
    }

    @Override
    public void atualizar(br.com.livrariademo.model.Livro livro) {
        this.livro = livro;
        mostrarElementos();
    }

    public void mostrarElementos() {
        System.out.println();
        System.out.println("**********************************************");
        System.out.println("************* TesteLivroObsUm **************");
        System.out.println("**********************************************");
        System.out.println("Codigo: " + livro.getCodigo());
        System.out.println("Nome:    " + livro.getNome());
        System.out.println("Isbn: " + livro.getIsbn());
        System.out.println("Paginas: " + livro.getNumeroPaginas());
        System.out.println("**********************************************");
    }

}
