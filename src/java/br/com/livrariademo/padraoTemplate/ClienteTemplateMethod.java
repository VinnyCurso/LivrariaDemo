/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.padraoTemplate;

import br.com.livrariademo.model.Cliente;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author vinicius caetano
 */
public abstract class ClienteTemplateMethod {
    
     private String Arquivo;
     
      public ClienteTemplateMethod(String nome) {
        Arquivo = nome;
    }
      
      public abstract boolean ePrimeiro(Cliente cliente1, Cliente cliente2);
      
       public Iterator<Cliente> listagemDeClientesNome() throws Exception {
        try {
            final ArrayList<Cliente> ArrayClientes = new ArrayList<>();
            FileReader fr = new FileReader(Arquivo);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            int posicao = 0;
            while ((linha = br.readLine()) != null) {
                Cliente aux = new Cliente(linha);
                ArrayClientes.add(aux);
                posicao++;
            }
            br.close();

            final int meio = ArrayClientes.size() / 2;

            //algoritmo de Ordenação
            Thread thread_1 = new Thread() {
                @Override
                public void run() {
                    for (int i = 0; i < meio; i++) {
                        for (int j = i; j < ArrayClientes.size(); j++) {

                            if (!ePrimeiro(ArrayClientes.get(i), ArrayClientes.get(j))) {
                                Cliente temp = ArrayClientes.get(j);
                                ArrayClientes.set(j, ArrayClientes.get(i));
                                ArrayClientes.set(i, temp);
                            }
                        }
                    }
                }
            };
            Thread thread_2 = new Thread() {
                @Override
                public void run() {
                    for (int i = meio + 1; i < ArrayClientes.size(); i++) {
                        for (int j = i; j < ArrayClientes.size(); j++) {

                            if (!ePrimeiro(ArrayClientes.get(i), ArrayClientes.get(j))) {
                                Cliente temp = ArrayClientes.get(j);
                                ArrayClientes.set(j, ArrayClientes.get(i));
                                ArrayClientes.set(i, temp);
                            }
                        }
                    }
                }
            };
            thread_1.start();
            thread_2.start();
            try {
                thread_1.join();
                thread_2.join();
            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(null, "Erro ==> " + e.getMessage());
            }

            return ArrayClientes.iterator();
        } catch (IOException erro) {
             JOptionPane.showMessageDialog(null, "Erro ==> " + erro.getMessage());
            throw erro;
        }
    }

    
}
