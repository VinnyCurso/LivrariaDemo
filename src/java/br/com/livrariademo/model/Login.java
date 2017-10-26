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
public class Login {
    
       private int codigo;
    private String login;
    private String senha;

    public Login() {
    }

    public Login(int codigo, String login, String senha) {
        this.codigo = codigo;
        this.login = login;
        this.senha = senha;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public boolean validarLoginSenha(String login,String senha){
        if(login.equalsIgnoreCase("admin")&& senha.equalsIgnoreCase("admin")){
            return true;
        }else{
             return false;
        }
  
    }
    
}
