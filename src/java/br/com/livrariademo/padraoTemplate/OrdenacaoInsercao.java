/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.padraoTemplate;

/**
 *
 * @author vinicius caetano
 */
public class OrdenacaoInsercao {

    public static void main(String[] args) {

        int vetor[] = {5, 7, 2, 8, 1, 6};
        int i;
        int j;
        int auxiliar;

        for (i = 1; i < vetor.length; i++) {

            auxiliar = vetor[i];
            j = i - 1;

            while (j >= 0 && vetor[j] > auxiliar) {
                vetor[j + 1] = vetor[j];
                j = j - 1;
            }
            vetor[j + 1] = auxiliar;

        }
        for (i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }

    }
}
