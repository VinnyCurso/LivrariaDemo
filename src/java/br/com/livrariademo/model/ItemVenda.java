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
public class ItemVenda {
    
    private Integer codigo;
    private Venda codigoVenda;
    private Livro codigoLivro;
    private Integer quantidadeVenda;

    public ItemVenda() {
    }

    public ItemVenda(Integer codigo, Venda codigoVenda, Livro codigoLivro, Integer quantidadeVenda) {
        this.codigo = codigo;
        this.codigoVenda = codigoVenda;
        this.codigoLivro = codigoLivro;
        this.quantidadeVenda = quantidadeVenda;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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

    public Integer getQuantidadeVenda() {
        return quantidadeVenda;
    }

    public void setQuantidadeVenda(Integer quantidadeVenda) {
        this.quantidadeVenda = quantidadeVenda;
    }

    @Override
    public String toString() {
        return "ItemVenda{" + "codigo=" + codigo + ", codigoVenda=" + codigoVenda + ", codigoLivro=" + codigoLivro + ", quantidadeVenda=" + quantidadeVenda + '}';
    }

    
    
}
