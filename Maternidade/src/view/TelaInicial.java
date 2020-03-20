/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.JTextFieldLimit;
import controller.TableModelFactory;
import java.awt.Rectangle;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import model.Doctor;
import model.DoctorDAO;

/**
 *
 * @author barab
 */
public class TelaInicial extends javax.swing.JFrame {

    /**
     * Creates new form TelaInicial
     */
    public TelaInicial() {
        initComponents();
        configComponents();
        preencheTabelaMaes();
        preencheTabelaMedicos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbpCategoriasPessoas = new javax.swing.JTabbedPane();
        pnlMaes = new javax.swing.JPanel();
        lblCPFMae = new javax.swing.JLabel();
        txtCPFMae = new javax.swing.JTextField();
        scrMaes = new javax.swing.JScrollPane();
        tblMaes = new javax.swing.JTable();
        btnBuscarMae = new javax.swing.JButton();
        btnInfoMae = new javax.swing.JButton();
        btnCadastrarMae = new javax.swing.JButton();
        btnExcluirMae = new javax.swing.JButton();
        pnlMedicos = new javax.swing.JPanel();
        lblCRMMedico = new javax.swing.JLabel();
        txtCRMMedico = new javax.swing.JTextField();
        btnBuscarMedico = new javax.swing.JButton();
        scrMedicos = new javax.swing.JScrollPane();
        tblMedicos = new javax.swing.JTable();
        btnCadastrarMedico = new javax.swing.JButton();
        btnExcluirMedico = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Inicial - Maternidade");
        setMinimumSize(new java.awt.Dimension(640, 480));

        lblCPFMae.setText("CPF:");

        tblMaes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Nome", "CPF", "RG"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrMaes.setViewportView(tblMaes);

        btnBuscarMae.setText("Buscar na lista");
        btnBuscarMae.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarMaeActionPerformed(evt);
            }
        });

        btnInfoMae.setText("Mais informações / Editar");
        btnInfoMae.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoMaeActionPerformed(evt);
            }
        });

        btnCadastrarMae.setText("Cadastrar");
        btnCadastrarMae.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarMaeActionPerformed(evt);
            }
        });

        btnExcluirMae.setText("Excluir");

        javax.swing.GroupLayout pnlMaesLayout = new javax.swing.GroupLayout(pnlMaes);
        pnlMaes.setLayout(pnlMaesLayout);
        pnlMaesLayout.setHorizontalGroup(
            pnlMaesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMaesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMaesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMaesLayout.createSequentialGroup()
                        .addComponent(lblCPFMae)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCPFMae)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarMae))
                    .addComponent(scrMaes, javax.swing.GroupLayout.DEFAULT_SIZE, 1354, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMaesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnExcluirMae)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnInfoMae)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCadastrarMae)))
                .addContainerGap())
        );

        pnlMaesLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCadastrarMae, btnExcluirMae});

        pnlMaesLayout.setVerticalGroup(
            pnlMaesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMaesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMaesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCPFMae)
                    .addComponent(txtCPFMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarMae))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrMaes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMaesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInfoMae)
                    .addComponent(btnCadastrarMae)
                    .addComponent(btnExcluirMae))
                .addContainerGap())
        );

        tbpCategoriasPessoas.addTab("Mães", pnlMaes);

        lblCRMMedico.setText("CRM:");

        btnBuscarMedico.setText("Buscar na lista");
        btnBuscarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarMedicoActionPerformed(evt);
            }
        });

        tblMedicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Especialidade", "CRM"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblMedicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMedicosMouseClicked(evt);
            }
        });
        scrMedicos.setViewportView(tblMedicos);

        btnCadastrarMedico.setText("Cadastrar");
        btnCadastrarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarMedicoActionPerformed(evt);
            }
        });

        btnExcluirMedico.setText("Excluir");
        btnExcluirMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirMedicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMedicosLayout = new javax.swing.GroupLayout(pnlMedicos);
        pnlMedicos.setLayout(pnlMedicosLayout);
        pnlMedicosLayout.setHorizontalGroup(
            pnlMedicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMedicosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMedicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrMedicos, javax.swing.GroupLayout.DEFAULT_SIZE, 1354, Short.MAX_VALUE)
                    .addGroup(pnlMedicosLayout.createSequentialGroup()
                        .addComponent(lblCRMMedico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCRMMedico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarMedico))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMedicosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnExcluirMedico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCadastrarMedico)))
                .addContainerGap())
        );

        pnlMedicosLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCadastrarMedico, btnExcluirMedico});

        pnlMedicosLayout.setVerticalGroup(
            pnlMedicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMedicosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMedicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCRMMedico)
                    .addComponent(txtCRMMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarMedico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrMedicos, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMedicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrarMedico)
                    .addComponent(btnExcluirMedico))
                .addContainerGap())
        );

        tbpCategoriasPessoas.addTab("Médicos", pnlMedicos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbpCategoriasPessoas)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbpCategoriasPessoas)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarMaeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarMaeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarMaeActionPerformed

    private void btnInfoMaeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoMaeActionPerformed
        TelaInfoMae telaInfoMae = new TelaInfoMae(this, true);
        telaInfoMae.setLocationRelativeTo(null);
        telaInfoMae.setVisible(true);
    }//GEN-LAST:event_btnInfoMaeActionPerformed

    private void btnCadastrarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarMedicoActionPerformed
        TelaCadastrMedico telaCadastrMedico = new TelaCadastrMedico(this, true);
        telaCadastrMedico.setLocationRelativeTo(this);
        telaCadastrMedico.setVisible(true);
        preencheTabelaMedicos();
        btnExcluirMedico.setEnabled(false); // Porque nenhum item da tabela estará selecionado.
    }//GEN-LAST:event_btnCadastrarMedicoActionPerformed

    private void btnCadastrarMaeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarMaeActionPerformed
        TelaCadastrMae telaCadastrMae = new TelaCadastrMae(null, true);
        telaCadastrMae.setLocationRelativeTo(null);
        telaCadastrMae.setVisible(true);
    }//GEN-LAST:event_btnCadastrarMaeActionPerformed

    private void btnExcluirMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirMedicoActionPerformed
        int indices[] = tblMedicos.getSelectedRows();
        if (indices.length > 0) {
            if (indices.length > 1) {
                int opcao = JOptionPane.showConfirmDialog(null, "Confirma "
                        + "exclusão de vários médicos?", "Confirmação de "
                                + "exclusão", JOptionPane.YES_NO_OPTION);
                if (opcao == JOptionPane.YES_OPTION) {
                    for (int indice : indices) {
                        TableModel modelo = tblMedicos.getModel();
                        String CRM = modelo.getValueAt(indice, 2).toString();
                        DoctorDAO.delete(CRM);
                    }
                }
            } else {
                TableModel modelo = tblMedicos.getModel();
                String CRM = modelo.getValueAt(indices[0], 2).toString();
                DoctorDAO.delete(CRM);
            }
            preencheTabelaMedicos();
            btnExcluirMedico.setEnabled(false); // Porque nenhum item da tabela estará selecionado.
        }
    }//GEN-LAST:event_btnExcluirMedicoActionPerformed

    private void btnBuscarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarMedicoActionPerformed
        boolean encontrado = false;
        for (int i = 0; i < tblMedicos.getRowCount(); i++) {
            if (tblMedicos.getModel().getValueAt(i, 2).equals(txtCRMMedico.getText())) {
                tblMedicos.setRowSelectionInterval(i, i);
                Rectangle cellRectangle = tblMedicos.getCellRect(i, 0, false);
                tblMedicos.scrollRectToVisible(cellRectangle);
                encontrado = true;
                btnExcluirMedico.setEnabled(true);
                break;
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(rootPane, "Médico não encontrado.");
        }
    }//GEN-LAST:event_btnBuscarMedicoActionPerformed

    private void tblMedicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMedicosMouseClicked
        btnExcluirMedico.setEnabled(true);
    }//GEN-LAST:event_tblMedicosMouseClicked

    private void configComponents() {
        txtCRMMedico.setDocument(new JTextFieldLimit(Doctor.TAM_MAX_CRM));
        btnExcluirMedico.setEnabled(false);
        scrMedicos.setViewportView(tblMedicos);
        configBtnBuscarMedico();
        configBtnBuscarMae();
    }

    private void configBtnBuscarMedico() {
        btnBuscarMedico.setEnabled(false);

        DocumentListener txtCRMMedicoListenter = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent evt) {
                defineEstadoBtnBuscarMedico(evt);
            }

            @Override
            public void removeUpdate(DocumentEvent evt) {
                defineEstadoBtnBuscarMedico(evt);
            }

            @Override
            public void changedUpdate(DocumentEvent evt) {
                defineEstadoBtnBuscarMedico(evt);
            }

            private void defineEstadoBtnBuscarMedico(DocumentEvent evt) {
                if (txtCRMMedico.getText().equals("")) {
                    btnBuscarMedico.setEnabled(false);
                } else {
                    btnBuscarMedico.setEnabled(true);
                }
            }
        };

        txtCRMMedico.getDocument().addDocumentListener(txtCRMMedicoListenter);
    }

    private void configBtnBuscarMae() {
        btnBuscarMae.setEnabled(false);

        DocumentListener txtCRMMedicoListenter = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent evt) {
                defineEstadoBtnBuscarMae(evt);
            }

            @Override
            public void removeUpdate(DocumentEvent evt) {
                defineEstadoBtnBuscarMae(evt);
            }

            @Override
            public void changedUpdate(DocumentEvent evt) {
                defineEstadoBtnBuscarMae(evt);
            }

            private void defineEstadoBtnBuscarMae(DocumentEvent evt) {
                if (txtCPFMae.getText().equals("")) {
                    btnBuscarMae.setEnabled(false);
                } else {
                    btnBuscarMae.setEnabled(true);
                }
            }
        };

        txtCPFMae.getDocument().addDocumentListener(txtCRMMedicoListenter);
    }

    private void preencheTabelaMaes() {

    }

    private void preencheTabelaMedicos() {
        tblMedicos.setModel(new TableModelFactory().criarTblModelTodosMedicos());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaInicial telaInicial = new TelaInicial();
                telaInicial.setLocationRelativeTo(null);
                telaInicial.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarMae;
    private javax.swing.JButton btnBuscarMedico;
    private javax.swing.JButton btnCadastrarMae;
    private javax.swing.JButton btnCadastrarMedico;
    private javax.swing.JButton btnExcluirMae;
    private javax.swing.JButton btnExcluirMedico;
    private javax.swing.JButton btnInfoMae;
    private javax.swing.JLabel lblCPFMae;
    private javax.swing.JLabel lblCRMMedico;
    private javax.swing.JPanel pnlMaes;
    private javax.swing.JPanel pnlMedicos;
    private javax.swing.JScrollPane scrMaes;
    private javax.swing.JScrollPane scrMedicos;
    private javax.swing.JTable tblMaes;
    private javax.swing.JTable tblMedicos;
    private javax.swing.JTabbedPane tbpCategoriasPessoas;
    private javax.swing.JTextField txtCPFMae;
    private javax.swing.JTextField txtCRMMedico;
    // End of variables declaration//GEN-END:variables
}
