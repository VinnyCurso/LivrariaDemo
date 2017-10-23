/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.model;

//import java.util.ArrayList;
//import java.util.List;

/**
 *
 * @author vinicius caetano
 */
public class Usuario {
    
    private int codigo;
    private String login;
    private String password;
    private String confirmacaoPassword;
    private String name;
//    private List<Role> roles = new ArrayList<>();
    private int ativo;

    public Usuario() {
    }

    public Usuario(int codigo,String login, String password, String confirmacaoPassword) {
        this.codigo=codigo;
        this.login = login;
        this.password = password;
        this.confirmacaoPassword = confirmacaoPassword;
    }

    public Usuario(int codigo,String login, String password, String confirmacaoPassword, String name, int ativo) {
        this.codigo=codigo;
        this.login = login;
        this.password = password;
        this.confirmacaoPassword = confirmacaoPassword;
        this.name = name;
        this.ativo = ativo;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmacaoPassword() {
        return confirmacaoPassword;
    }

    public void setConfirmacaoPassword(String confirmacaoPassword) {
        this.confirmacaoPassword = confirmacaoPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(List<Role> roles) {
//        this.roles = roles;
//    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }
    
    
    public boolean validarSenha(){
		if (password.equals(confirmacaoPassword)){
			return true;
		}else return false;
	}

   
 
    
}
