/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.model;

/**
 *
 * @author vinicius caetano
 */
public class ItemVendaID {
    
private Venda codigoVenda;
private Livro codigoLivro;

    public ItemVendaID() {
    }

    public ItemVendaID(Venda codigoVenda, Livro codigoLivro) {
        this.codigoVenda = codigoVenda;
        this.codigoLivro = codigoLivro;
    }

    public Venda getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(Venda codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public Livro getCodigoLivro() {
        return codigoLivro;
    }

    public void setCodigoLivro(Livro codigoLivro) {
        this.codigoLivro = codigoLivro;
    }

    @Override
    public String toString() {
        return "ItemVendaID{" + "codigoVenda=" + codigoVenda + ", codigoLivro=" + codigoLivro + '}';
    }


    
    
    
    
    
    
}
