/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.util;

import br.com.livrariademo.model.Cliente;

/**
 *
 * @author vinicius caetano
 */
public class Arvore {

    private Cliente dados;
    private Arvore esquerda;
    private Arvore direita;

    public Arvore() {
        this.esquerda = this.direita = null;
    }

    public Arvore(Cliente cliente) {
        this.dados = cliente;
        this.esquerda = this.direita = null;
    }

    public Arvore inserir(Arvore arvore, Cliente cliente) {
        if (arvore == null) {
            arvore = new Arvore(cliente);
        } else if (cliente.getCodigo() < arvore.dados.getCodigo()) {
            arvore.esquerda = inserir(arvore.esquerda, cliente);
        } else {
            arvore.direita = inserir(arvore.direita, cliente);
        }
        return arvore;
    }

    public Arvore remover(Arvore arvore, Cliente cliente) {

        if (arvore == null) {
            return null;
        } else if (arvore.dados.getCodigo() > cliente.getCodigo()) {
            arvore.esquerda = remover(arvore.esquerda, cliente);
        } else if (arvore.dados.getCodigo() < cliente.getCodigo()) {
            arvore.direita = remover(arvore.direita, cliente);
        } else {

            if (arvore.esquerda == null && arvore.direita == null) {
                arvore = null;
            } else if (arvore.esquerda == null) {
                Arvore aux = arvore;
                arvore = arvore.direita;
                aux = null;
            } else if (arvore.direita == null) {
                Arvore aux = arvore;
                arvore = arvore.esquerda;
                aux = null;
            } else {
                Arvore aux = arvore.esquerda;

                while (aux.direita != null) {
                    aux = aux.direita;
                }

                arvore.dados = aux.dados;
                aux.dados = cliente;
                arvore.esquerda = remover(arvore.esquerda, cliente);
            }
        }
        return arvore;
    }

    public void imprimirOrdem(Arvore raiz) {
        if (raiz == null) {
            return;
        }
        imprimirOrdem(raiz.esquerda);
//        System.out.println(raiz.dados + " ");
        imprimirOrdem(raiz.direita);
    }

    public void imprimirPreOrder(Arvore raiz) {
        if (raiz == null) {
            return;
        }
//        System.out.println(raiz.dados + " ");
        imprimirPreOrder(raiz.esquerda);
        imprimirPreOrder(raiz.direita);
    }

    public void imprimirPosOrder(Arvore raiz) {
        if (raiz == null) {
            return;
        }
        imprimirPosOrder(raiz.esquerda);
        imprimirPosOrder(raiz.direita);
//        System.out.println(raiz.dados + " ");
    }

    public Arvore getEsquerda(Arvore raiz) {
        return raiz.esquerda;
    }

    public Arvore getDireita(Arvore raiz) {
        return raiz.esquerda;
    }

}
