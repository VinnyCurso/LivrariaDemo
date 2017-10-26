/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.util;

import br.com.livrariademo.padraoDecorator.ItemCarrinho;
import br.com.livrariademo.padraoDecorator.Livro;
import br.com.livrariademo.padraoDecorator.LivroOne;
import br.com.livrariademo.padraoDecorator.LivroTwo;

/**
 *
 * @author vinicius caetano
 */
public class JanelaTesteDecorator {
    
    public static void main(String[] args) {
        
        ItemCarrinho item = new Livro();
        System.out.println("-------------------------------------------------");
        System.out.println("Item:   "+ item.getDescricao());
        System.out.println("ValorTotal:  " + item.preco());
        System.out.println("-------------------------------------------------");
        
        item = new LivroOne(item);
        System.out.println("-------------------------------------------------");
        System.out.println("Item:   "+ item.getDescricao());
        System.out.println("ValorTotal:  " + item.preco());
        System.out.println("-------------------------------------------------");
        
        item = new LivroTwo(item);
        System.out.println("-------------------------------------------------");
        System.out.println("Item:   "+ item.getDescricao());
        System.out.println("ValorTotal:  " + item.preco());
        System.out.println("-------------------------------------------------");
        
    }
    
}
