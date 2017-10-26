/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.model;

import java.time.Instant;
import java.util.Date;

/**
 *
 * @author vinicius caetano
 */
public class Cliente {
    
    private int codigo;
    private String nome;
    private String email;
    private String telefone;
    private Long cpf;
    private Date dataCadastro;

    public Cliente() {
    }

    public Cliente(int codigo, String nome, String email, String telefone, Long cpf, Date dataCadastro) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.dataCadastro = dataCadastro;
    }
    
     public Cliente(String str){
        String[] vetor = str.split(";");
        this.codigo = Integer.parseInt(vetor[0]);
        this.nome = vetor[1];
        this.email = vetor[2];
        this.telefone = vetor[3];
        this.cpf = Long.parseLong(vetor[4]);
//        this.dataCadastro = new java.sql.Date(vetor[5]);

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        return "Cliente{" + "codigo=" + codigo + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", cpf=" + cpf + ", dataCadastro=" + dataCadastro + '}';
    }
 
}
