/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.livrariademo.padraoDecorator;

/**
 *
 * @author eugenio
 */
public class LivroOne extends Acessorio {
    private ItemCarrinho itemCarrinho;
    public LivroOne(ItemCarrinho itens){
        this.itemCarrinho = itens;
    }
    @Override
    public String getDescricao(){
        return itemCarrinho.getDescricao() + ", LivroOne";
    }
    @Override
    public double preco(){
        return 2500 + itemCarrinho.preco();
    }
}
