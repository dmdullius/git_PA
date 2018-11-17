/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Controller.OSController;
import Model.Ordem_Servico;
import ferramentas.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;


public class ValidacaoOS extends javax.swing.JFrame {

    /**
     * Creates new form ViewAlunos
     */
    Combos cbOS;
    Ordem_Servico objOS;

    public ValidacaoOS() {
        initComponents();

        try {
            //carregar os alunos existentes
            atualizarTabela();

            //carregar os técnicos existentes
            cbOS = new Combos(jcbOS_tecnicos);
            cbOS.PreencheCombo("SELECT codigo, nome FROM tecnicos ORDER BY nome");

            limparTela();

        } catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("ERRO:" + ex.getMessage());
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        finalizado = new javax.swing.JTextField();
        pendente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        codigo = new javax.swing.JFormattedTextField();
        jcbOS_tecnicos = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btnAlterar = new javax.swing.JButton();
        btnIncluir = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        desc = new javax.swing.JTextPane();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableOS = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(20, 100));
        setResizable(false);

        jLabel1.setText("finalizado");

        jLabel2.setText("Pendente");

        jLabel3.setText("Técnico");

        jLabel4.setText("Codigo");

        codigo.setEnabled(false);

        jcbOS_tecnicos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbOS_tecnicos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbOS_tecnicosItemStateChanged(evt);
            }
        });

        jLabel5.setText("OS já cadastradas");

        btnAlterar.setText("ALTERAR");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnIncluir.setText("INCLUIR");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });

        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnLimpar.setText("LIMPAR");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(desc);

        jLabel6.setText("Descrição ");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/back-button.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTableOS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Técnico", "Descrição", "Pendente", "Finalizado"
            }
        ));
        jTableOS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableOSMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableOS);
        if (jTableOS.getColumnModel().getColumnCount() > 0) {
            jTableOS.getColumnModel().getColumn(0).setResizable(false);
            jTableOS.getColumnModel().getColumn(0).setHeaderValue("Técnico");
            jTableOS.getColumnModel().getColumn(1).setHeaderValue("Descrição");
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(finalizado, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jcbOS_tecnicos, 0, 185, Short.MAX_VALUE)
                            .addComponent(pendente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(btnIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(btnLimpar))
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pendente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(finalizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbOS_tecnicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterar)
                    .addComponent(btnIncluir)
                    .addComponent(btnExcluir)
                    .addComponent(btnLimpar))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void atualizarTabela() {
        try {
            JTable jtbOS = null;
            OSController objOScon = new OSController(objOS, null);
            OSController objOSCon = new OSController(null, jtbOS);
            objOScon.PreencheOS();

        } catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("ERRO:" + ex.getMessage());
        }
    }
    

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        try {
            //if(validaDados()){
            OSController objOScon = new OSController(objOS, null);
            guardarDados();

            if (objOScon.alterar() == true) {
                CaixaDeDialogo.obterinstancia().exibirMensagem("OS alterada com Sucesso!");
            } else {
                CaixaDeDialogo.obterinstancia().exibirMensagem("OPS! Erro ao alterar OS, que pena!!!");
            }

            limparTela();
            //}
        } catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void guardarDados() {
        try {
            Ordem_Servico objOS = new Ordem_Servico();

            objOS.setCodigo(Integer.parseInt(codigo.getText()));
            objOS.setDescricao(finalizado.getText());

            //AJUSTA A DATA PARA ANO-MES-DIA PARA GRAVAR NO BANCO
            //String dataFormatada = Formatacao.ajustaDataAMD(txtDataNascimento.getText());
            //objAluno.setDat_nasc(dataFormatada);
            //RECUPERANDO O CODIGO DO CURSO DO JCOMBOBOX
            Combos c = (Combos) jcbOS_tecnicos.getSelectedItem();
            String codigo = c.getCodigo();
            objOS.setCodigo(Integer.parseInt(codigo));

        } catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Problemas no guardaDados: " + ex.getMessage());
        }
    }

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
        if (validarDados() == true) {
            //PREENCHE O OBJETO OS
            guardarDados();

            OSController objOSCon = new OSController(objOS, null);
            try {
                if (objOSCon.incluir() == true) {
                    CaixaDeDialogo.obterinstancia().exibirMensagem("OS incluída com Sucesso!");
                } else {
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao incluir OS!");
                }
            } catch (Exception ex) {
                CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
            }

            limparTela();
        }
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void limparTela() {
        try {
            //LIMPAR OS CAMPOS DA TELA
            //LIBERAR O CAMPO Codigo

            codigo.setText("");
            finalizado.setText("");
            pendente.setText("");
            cbOS.SetaComboBox("");
            codigo.setEnabled(true);
            
            atualizarTabela();

        } catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
    }

    private boolean validarDados() {
        try {
            //VALIDAR O CAMPOS DA TELA
            //RETURN FALSE SE ALGUM CAMPO NAO ESTA PREENCHIDO CORRETAMENTE

            return true;
        } catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
            return false;
        }
    }

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        OSController objOSCon = new OSController(null, null);
        try {
            if (objOSCon.excluir() == true) {
                CaixaDeDialogo.obterinstancia().exibirMensagem("OS removida com Sucesso!");
            } else {
                CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao remover OS!");
            }
        } catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }

        limparTela();

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparTela();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void jcbOS_tecnicosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbOS_tecnicosItemStateChanged
        try {
            Combos c = (Combos) jcbOS_tecnicos.getSelectedItem();
            String codigo = c.getCodigo();

        } catch (Exception ex) {

        }
    }//GEN-LAST:event_jcbOS_tecnicosItemStateChanged

    private void jcbOS_tecnicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbOS_tecnicosActionPerformed
        
    }//GEN-LAST:event_jcbOS_tecnicosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Sistema tela = new Sistema();
            tela.setVisible(true);
            this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTableOSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableOSMouseClicked
     int linha;
     linha = jTableOS.getSelectedRow();
     codigo.setText(jTableOS.getValueAt(linha, 0).toString());
     desc.setText(jTableOS.getValueAt(linha, 1).toString());
     pendente.setText(jTableOS.getValueAt(linha, 2).toString());
     finalizado.setText(jTableOS.getValueAt(linha, 3).toString());
     cbOS.SetaComboBox(jTableOS.getValueAt(linha, 4).toString());
     
    }//GEN-LAST:event_jTableOSMouseClicked

       public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ValidacaoOS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JFormattedTextField codigo;
    private javax.swing.JTextPane desc;
    private javax.swing.JTextField finalizado;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableOS;
    private javax.swing.JComboBox<String> jcbOS_tecnicos;
    private javax.swing.JTextField pendente;
    // End of variables declaration//GEN-END:variables
}



