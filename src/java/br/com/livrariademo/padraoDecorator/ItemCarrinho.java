/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.livrariademo.padraoDecorator;

/**
 *
 * @author eugenio
 */
public abstract  class ItemCarrinho {
    String descricao = "Carro";

	public String getDescricao() {
		return descricao;
	}
        
	public abstract double preco();
}
