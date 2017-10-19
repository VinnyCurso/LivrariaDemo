/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.model;

import br.com.livrariademo.enums.TipoPagamento;

/**
 *
 * @author vinicius caetano
 */
public class Venda {
    
    private int codigo;
    private Cliente cliente;
    private Usuario usuario;
    private Double valorTotal;
    private TipoPagamento tipoPagamento;

    public Venda() {
    }

    public Venda(int codigo, Cliente cliente, Usuario usuario, Double valorTotal, TipoPagamento tipoPagamento) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.usuario = usuario;
        this.valorTotal = valorTotal;
        this.tipoPagamento = tipoPagamento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    @Override
    public String toString() {
        return "Venda{" + "codigo=" + codigo + ", cliente=" + cliente + ", usuario=" + usuario + ", valorTotal=" + valorTotal + ", tipoPagamento=" + tipoPagamento + '}';
    }
    
    
    
}
