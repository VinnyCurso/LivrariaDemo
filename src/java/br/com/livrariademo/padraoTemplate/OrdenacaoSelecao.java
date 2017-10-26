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
public class OrdenacaoSelecao {

    public static void main(String[] args) {

        int vetor[] = {5, 7, 2, 8, 1, 6};
        int i;
        int j;
        int auxiliar;
        int minimo;

        for (i = 0; i <= vetor.length - 2; i++) {
            minimo = i;

            for (j = (i + 1); j <= vetor.length - 1; j++) {

                if (vetor[j] < vetor[minimo]) {
                    minimo = j;
                }

                auxiliar = vetor[i];
                vetor[i] = vetor[minimo];
                vetor[minimo] = auxiliar;
            }

            for (i = 0; i < vetor.length; i++) {
                System.out.println(vetor[i]);

            }
        }
    }
}
