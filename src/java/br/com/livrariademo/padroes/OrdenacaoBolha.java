/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.padroes;

/**
 *
 * @author vinicius caetano
 */
public class OrdenacaoBolha {

    public static void main(String[] args) {

        int vetor[] = {7, 4, 25, 20, 10, 8};
        int contador1;
        int contador2;
        int temporario;

        for (contador1 = vetor.length - 1; contador1 > 0; contador1--) {

            for (contador2 = 0; contador2 < contador1; contador2++) {

                if (vetor[contador2] > vetor[contador2 + 1]) {

                    temporario = vetor[contador2];
                    vetor[contador2] = vetor[contador2 + 1];
                    vetor[contador2 + 1] = temporario;

                }

            }

        }

        for (contador1 = 0; contador1 < vetor.length; contador1++) {
            System.out.println(vetor[contador1]);

        }

    }

}
