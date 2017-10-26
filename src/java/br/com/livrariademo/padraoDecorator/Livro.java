/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.livrariademo.padraoDecorator;

/**
 *
 * @author eugenio
 */
public class Livro extends ItemCarrinho{
    public Livro(){
        descricao = "LivroFVO";
    }
    public double preco(){
        return 22.00;
    }

}
