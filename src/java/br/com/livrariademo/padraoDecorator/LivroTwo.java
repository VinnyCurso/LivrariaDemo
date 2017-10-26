/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.padraoDecorator;

/**
 *
 * @author vinicius caetano
 */
public class LivroTwo extends Acessorio {
    
     private ItemCarrinho itemCarrinho;
    
     
     public LivroTwo(ItemCarrinho itens){
        this.itemCarrinho = itens;
    }

     @Override
    public String getDescricao(){
        return itemCarrinho.getDescricao() + ", LivroTwo";
    }
     @Override
    public double preco(){
        return 70.0 + itemCarrinho.preco();
    }
    
}
