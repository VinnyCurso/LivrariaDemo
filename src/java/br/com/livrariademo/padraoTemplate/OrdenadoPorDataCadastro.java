/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.padraoTemplate;

import br.com.livrariademo.model.Cliente;

/**
 *
 * @author vinicius caetano
 */
public class OrdenadoPorDataCadastro extends ClienteTemplateMethod {

    public OrdenadoPorDataCadastro(String nome) {
        super(nome);
    }

    @Override
    public boolean ePrimeiro(Cliente cliente1, Cliente cliente2) {
        return false;
    }
    }
    

