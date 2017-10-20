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
public class Lista {
    
    private Cliente primeiro;
    private Cliente ultimo;

    Lista() {
        primeiro = null;
        ultimo = null;
    }

    public boolean eVazia() {
        return getPrimeiro() == null;
    }

    public void addInicio(Cliente objeto) {

//        objeto.setProximo(null);
        if (eVazia()) {
            setPrimeiro(objeto);
            ultimo = objeto;
        } else {
//            objeto.setProximo(getPrimeiro());
            setPrimeiro(objeto);
        }
    }

    public void addFim(Cliente objeto) {

//        objeto.setProximo(null);
        if (eVazia()) {
            setPrimeiro(objeto);
            ultimo = objeto;
        } else {
//            ultimo.setProximo(objeto);
            ultimo = objeto;
        }
    }

    public Cliente getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(Cliente primeiro) {
        this.primeiro = primeiro;
    }
    
}
