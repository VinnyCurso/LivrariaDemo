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
public class AcabamentoLivro {
    
    private int codigo;
    private String descricao;

    public AcabamentoLivro() {
    }

    public AcabamentoLivro(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "AcabamentoLivro{" + "codigo=" + codigo + ", descricao=" + descricao + '}';
    }
    
    
    
}
