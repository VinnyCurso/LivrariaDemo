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
public class Fila {
    
    private Cliente inicio;
    private Cliente fim;
    
    //cria uma fila vazia
    public Fila(){
        inicio = null;
        fim = null;
    }
    
    //verifica se uma fila esta vazia
    public boolean eVazia(){
        return inicio == null;
    }
    //enfileirar...
    public void enfileirar(Cliente cliente){
//        cliente.setProximo(null);
        if(eVazia()){
            inicio = cliente;
            fim = cliente;
        }else{
//            fim.setProximo(cliente);
            fim = cliente;
        }
    }

    public Cliente getInicio() {
        return inicio;
    }
    
}
