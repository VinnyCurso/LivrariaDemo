/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.util;

import br.com.livrariademo.model.Cliente;
import br.com.livrariademo.padraoTemplate.OrdenadoPorCPF;
import br.com.livrariademo.padraoTemplate.OrdenadoPorCodigo;
import br.com.livrariademo.padraoTemplate.OrdenadoPorDataCadastro;
import br.com.livrariademo.padraoTemplate.OrdenadoPorEmail;
import br.com.livrariademo.padraoTemplate.OrdenadoPorNome;
import br.com.livrariademo.padraoTemplate.OrdenadoPorTelefone;
import javax.swing.JOptionPane;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aluno
 */
public class JanelaTesteTemplate extends javax.swing.JFrame {
    
    public JanelaTesteTemplate() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableGridCliente = new javax.swing.JTable();
        btnPorNome = new javax.swing.JToggleButton();
        btnPorMatricula = new javax.swing.JButton();
        btnPorDptoeNome = new javax.swing.JButton();
        btnPorTitulacaoeNome = new javax.swing.JButton();
        btnPorRegimeNome = new javax.swing.JButton();
        btnPorDptoTitulacaoeNome = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista de Professores");

        jTableGridCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "Email", "Telefone", "CPF", "Data Cadastro"
            }
        ));
        jScrollPane1.setViewportView(jTableGridCliente);

        btnPorNome.setText("Nome");
        btnPorNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPorNomeActionPerformed(evt);
            }
        });

        btnPorMatricula.setText("Codigo");
        btnPorMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPorMatriculaActionPerformed(evt);
            }
        });

        btnPorDptoeNome.setText("Email");
        btnPorDptoeNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPorDptoeNomeActionPerformed(evt);
            }
        });

        btnPorTitulacaoeNome.setText("Telefone");
        btnPorTitulacaoeNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPorTitulacaoeNomeActionPerformed(evt);
            }
        });

        btnPorRegimeNome.setText("CPF");
        btnPorRegimeNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPorRegimeNomeActionPerformed(evt);
            }
        });

        btnPorDptoTitulacaoeNome.setText("Data Cadastro");
        btnPorDptoTitulacaoeNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPorDptoTitulacaoeNomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnPorNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPorMatricula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPorDptoeNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPorTitulacaoeNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPorRegimeNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPorDptoTitulacaoeNome)
                .addContainerGap(688, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPorNome)
                    .addComponent(btnPorMatricula)
                    .addComponent(btnPorDptoeNome)
                    .addComponent(btnPorTitulacaoeNome)
                    .addComponent(btnPorRegimeNome)
                    .addComponent(btnPorDptoTitulacaoeNome))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void imprimirNaGrid(Iterator<Cliente> dados) {
        try {
            DefaultTableModel model = (DefaultTableModel) jTableGridCliente.getModel();
            model.setNumRows(0);
            while (dados.hasNext()) {
                String[] linha = new String[7];
                Cliente obj = dados.next();
                linha[0] = "" + obj.getCodigo();
                linha[1] = obj.getNome();
                linha[2] = obj.getEmail();
                linha[3] = obj.getTelefone();
                linha[4] = "" + obj.getCpf();
                linha[5] = "" + obj.getDataCadastro();
                model.addRow(linha);
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro);
        }
    }
    private void btnPorNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPorNomeActionPerformed
        
        try {
            String nome = "src/java/arquivoteste/cliente.csv";
            
            OrdenadoPorNome objeto = new OrdenadoPorNome(nome);
            imprimirNaGrid(objeto.listagemDeClientesNome());
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro);
        }
    }//GEN-LAST:event_btnPorNomeActionPerformed

    private void btnPorMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPorMatriculaActionPerformed
        try {
            String nome = "src//java/arquivoteste/cliente.csv";
            
            OrdenadoPorCodigo objeto = new OrdenadoPorCodigo(nome);
            imprimirNaGrid(objeto.listagemDeClientesNome());
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro);
        }
    }//GEN-LAST:event_btnPorMatriculaActionPerformed

    private void btnPorDptoeNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPorDptoeNomeActionPerformed
        try {
            String nome = "src/java/arquivoteste/cliente.csv";
            
            OrdenadoPorEmail objeto = new OrdenadoPorEmail(nome);
            imprimirNaGrid(objeto.listagemDeClientesNome());
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro);
        }
    }//GEN-LAST:event_btnPorDptoeNomeActionPerformed

    private void btnPorTitulacaoeNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPorTitulacaoeNomeActionPerformed
        try {
            String nome = "src/java/arquivoteste/cliente.csv";
            
            OrdenadoPorTelefone objeto = new OrdenadoPorTelefone(nome);
            imprimirNaGrid(objeto.listagemDeClientesNome());
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro);
        }
    }//GEN-LAST:event_btnPorTitulacaoeNomeActionPerformed

    private void btnPorRegimeNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPorRegimeNomeActionPerformed
        try {
            String nome = "src/java/arquivoteste/cliente.csv";
            
            OrdenadoPorCPF objeto = new OrdenadoPorCPF(nome);
            imprimirNaGrid(objeto.listagemDeClientesNome());
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro);
        }
    }//GEN-LAST:event_btnPorRegimeNomeActionPerformed

    private void btnPorDptoTitulacaoeNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPorDptoTitulacaoeNomeActionPerformed
        try {
            String nome = "src/java/arquivoteste/cliente.csv";
            
            OrdenadoPorDataCadastro objeto = new OrdenadoPorDataCadastro(nome);
            imprimirNaGrid(objeto.listagemDeClientesNome());
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro);
        }
    }//GEN-LAST:event_btnPorDptoTitulacaoeNomeActionPerformed
    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaTesteTemplate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                new JanelaTesteTemplate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPorDptoTitulacaoeNome;
    private javax.swing.JButton btnPorDptoeNome;
    private javax.swing.JButton btnPorMatricula;
    private javax.swing.JToggleButton btnPorNome;
    private javax.swing.JButton btnPorRegimeNome;
    private javax.swing.JButton btnPorTitulacaoeNome;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableGridCliente;
    // End of variables declaration//GEN-END:variables
}
