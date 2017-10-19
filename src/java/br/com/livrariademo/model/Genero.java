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
public class Genero {
    
     private int codigo;
    private String descricao;

    public Genero() {
    }

    public Genero(int codigo, String descricao) {
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
        return "Genero{" + "codigo=" + codigo + ", descricao=" + descricao + '}';
    }
    
    

    
}
