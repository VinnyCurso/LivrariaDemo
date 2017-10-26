/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.business;

import br.com.livrariademo.dao.ClienteDao;
import br.com.livrariademo.model.Cliente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author vinicius caetano
 */
public class ClienteBusiness {

    ClienteDao dao;

    public ClienteBusiness() throws SQLException {
        dao = new ClienteDao();
    }

    public void Salvar(Cliente cliente) throws SQLException, Exception {

        if (validar(cliente)) {
            if (cliente.getCodigo() == 0) {
                dao.Cadastrar(cliente);
            } else {
                dao.Atualizar(cliente);
            }
        }
    }

    public void Excluir(int codigo) throws SQLException, Exception {
        dao.Deletar(codigo);
    }

    public Cliente Consultar(int codigo) throws SQLException {
        return dao.Consultar(codigo);
    }

    public List<Cliente> listar(String descricao) throws SQLException {
        return dao.Listar();
    }

    private boolean validar(Cliente cliente) throws Exception {
        if (cliente.getNome() == null) {
            throw new Exception("É necessário preencher o campo nome.");
        }
        if (cliente.getNome().isEmpty()) {
            throw new Exception("É necessário preencher o campo nome.");
        }

        if (cliente.getEmail() == null) {
            throw new Exception("É necessário preencher o campo email.");
        }
        if (cliente.getEmail().isEmpty()) {
            throw new Exception("É necessário preencher o campo email.");
        }

        if (cliente.getTelefone() == null) {
            throw new Exception("É necessário preencher o campo telefone.");
        }
        if (cliente.getTelefone().isEmpty()) {
            throw new Exception("É necessário preencher o campo telefone.");
        }

        if (cliente.getCpf() == null) {
            throw new Exception("É necessário preencher o campo CPF.");
        }

        if (cliente.getDataCadastro() == null) {
            throw new Exception("É necessário preencher o campo DataCadastro.");
        }

        return true;
    }
    
    private String cpf;
    private String mensagem;
    
      public boolean validarSequenciaCpf(String cpf) {//validação se o número informado do cpf é sequencial.
        boolean res = true; 
        
        if (cpf.equals("00000000000") || cpf.equals("11111111111")
            || cpf.equals("22222222222") || cpf.equals("33333333333")
            || cpf.equals("44444444444") || cpf.equals("55555555555")
            || cpf.equals("66666666666") || cpf.equals("77777777777")
            || cpf.equals("88888888888") || cpf.equals("99999999999")){
            
            res = false;
            mensagem = "Cadastro de pessoa física esta na ordem errada.";
            
        }else if (cpf.length() != 11){//validação se o número do cpf é diferente de 11 digitos.
            res = false;
            mensagem = "Cadastro de pessoa física fora dos padrões inválido."; 
        }
            
              System.out.println(res);
            return res;         
    } 
    
        
    public boolean calcularPrimeiroDigitoVerificador(String cpf){//validação do primeiro digito
        
       String s0  = cpf.substring(0,1);
       String s1  = cpf.substring(1,2);
       String s2  = cpf.substring(2,3);
       String s3  = cpf.substring(3,4);
       String s4  = cpf.substring(4,5);
       String s5  = cpf.substring(5,6);
       String s6  = cpf.substring(6,7);
       String s7  = cpf.substring(7,8);
       String s8  = cpf.substring(8,9);
             
       int sm = (Integer.parseInt(s0)  * 10)
               +(Integer.parseInt(s1)  * 9)
               +(Integer.parseInt(s2)  * 8)
               +(Integer.parseInt(s3)  * 7)
               +(Integer.parseInt(s4)  * 6)
               +(Integer.parseInt(s5)  * 5)
               +(Integer.parseInt(s6)  * 4)
               +(Integer.parseInt(s7)  * 3)
               +(Integer.parseInt(s8)  * 2);
       
       long digito = 11 - (sm % 11);
       long dv1 = 0;
       boolean res = false;
      
       if ((digito == 10) || (digito == 11)){
            dv1 = 0;
       }else{
            dv1 = digito; 
       }
        if (dv1 ==  digito || dv1 == 0) {   
            res = true;
        } else {
            res = false;
        }
            System.out.println(res);
            return res;         
    } 
    
    
    public boolean calcularSegundoDigitoVerificador(String cpf){//validação do segundo digito
        
       String s0  = cpf.substring(0,1);
       String s1  = cpf.substring(1,2);
       String s2  = cpf.substring(2,3);
       String s3  = cpf.substring(3,4);
       String s4  = cpf.substring(4,5);
       String s5  = cpf.substring(5,6);
       String s6  = cpf.substring(6,7);
       String s7  = cpf.substring(7,8);
       String s8  = cpf.substring(8,9);
       String s9  = cpf.substring(9,10);
             
       int sm = (Integer.parseInt(s0)  * 11)
               +(Integer.parseInt(s1)  * 10)
               +(Integer.parseInt(s2)  * 9)
               +(Integer.parseInt(s3)  * 8)
               +(Integer.parseInt(s4)  * 7)
               +(Integer.parseInt(s5)  * 6)
               +(Integer.parseInt(s6)  * 5)
               +(Integer.parseInt(s7)  * 4)
               +(Integer.parseInt(s8)  * 3)
               +(Integer.parseInt(s9)  * 2);
       
       long digito = 11 - (sm % 11);
       long dv2 = 0;
       boolean res = false;
      
       if ((digito == 10) || (digito == 11)){
            dv2 = 0;
       }else{
            dv2 = digito; 
       }
        if (dv2 ==  digito || dv2 == 0) {   
            res = true;
        } else {
            res = false;
        }
       
            System.out.println(res);
            return res; 
    }    

    public void  validadorCpf(String cpf) {
        this.cpf = cpf;
        
       
        
        if ((calcularPrimeiroDigitoVerificador(cpf) == true) 
                && validarSequenciaCpf(cpf) == true 
                && calcularSegundoDigitoVerificador(cpf) == true ){
           
            mensagem = "Cadastro de pessoa física Válido:";
            
        }else {
            
            mensagem = "Cadastro de pessoa física Inválido:";
        }
    }

}
