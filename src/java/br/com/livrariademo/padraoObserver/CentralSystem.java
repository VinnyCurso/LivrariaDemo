/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.padraoObserver;

import br.com.livrariademo.model.Livro;
import java.util.ArrayList;

/**
 *
 * @author vinicius caetano
 */
public class CentralSystem implements Sujeito {
    
    private ArrayList observers;
    private Livro livro;
    
    public CentralSystem(){
        observers = new ArrayList();
    }

    @Override
    public void incluirObservador(Observador o) {
        observers.add(o);
    }

    @Override
    public void removerObservador(Observador o) {
       int i = observers.indexOf(o);   
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notificarObservador() {
        for (int i = 0; i < observers.size(); i++) {
            Observador observer = (Observador)observers.get(i);
            observer.atualizar(livro);
        }
    }
    
    public void setLivro(Livro livro){
        this.livro = livro;
        notificarObservador();
    }   
    
    
    
}
