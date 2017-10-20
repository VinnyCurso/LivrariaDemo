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
public class Pilha {
    
        private Cliente topo;
    //cria uma pilha vazia
    public Pilha(){
        topo = null;
    }
    //verifica se a pilha está vazia
    public boolean eVazia(){
        return topo == null;
    }
    //emplilhar
    public void empilhar(Cliente cliente){
//        cliente.setProximo(null);
        if(eVazia()){
            topo = cliente;
        }else{
//            cliente.setProximo(topo);
            topo = cliente;
        }
    }

    //retorna o topo da pilha
    public Cliente topoPilha(){
        return topo;
    }
    
}
