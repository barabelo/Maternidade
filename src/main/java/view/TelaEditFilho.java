/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.JTextFieldLimit;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;
import model.Baby;
import model.BabyDAO;
import model.ValorInvalidoException;
import model.ValorRepetidoException;

/**
 *
 * @author barab
 */
public class TelaEditFilho extends javax.swing.JDialog {

    private Baby oldBaby;

    /**
     * Creates new form dialogoEditFilho
     */
    public TelaEditFilho(java.awt.Frame parent, boolean modal, Baby baby) {
        super(parent, modal);
        this.oldBaby = baby;
        initComponents();
        configComponents();
        preencheCampos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIdentificador = new javax.swing.JLabel();
        txtIdentificador = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblAltura = new javax.swing.JLabel();
        lblPeso = new javax.swing.JLabel();
        lblDataNasc = new javax.swing.JLabel();
        txfDataNasc = new javax.swing.JFormattedTextField();
        lblSexo = new javax.swing.JLabel();
        cmbSexo = new javax.swing.JComboBox<>();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txfAltura = new javax.swing.JFormattedTextField();
        txfPeso = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar dados do filho");

        lblIdentificador.setText("Identificador:");

        lblNome.setText("Nome:");

        lblAltura.setText("Altura (cm):");

        lblPeso.setText("Peso (kg):");

        lblDataNasc.setText("Data de nascimento:");

        try {
            txfDataNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblSexo.setText("Sexo:");

        cmbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setText("Todos os campos são obrigatórios.");

        txfAltura.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        txfPeso.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblIdentificador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdentificador))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblAltura)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPeso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDataNasc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSexo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCancelar, btnSalvar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdentificador)
                    .addComponent(txtIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAltura)
                    .addComponent(lblPeso)
                    .addComponent(lblDataNasc)
                    .addComponent(txfDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSexo)
                    .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (todosOsCamposObrigatoriosDoFilhoForamPreench()) {
            try {
                BabyDAO.update(oldBaby.getID(), pegaDadosBebe());
                dispose();
            } catch (ValorInvalidoException | ValorRepetidoException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(),
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane,
                    "Nem todos os campos do bebê foram preenchidos.\nTodos "
                    + "eles são obrigatórios.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private boolean todosOsCamposObrigatoriosDoFilhoForamPreench() {
        return !(txtIdentificador.getText().isEmpty()
                || txtNome.getText().isEmpty()
                || txfAltura.getText().isEmpty()
                || txfPeso.getText().isEmpty()
                || txfDataNasc.getText().contains(" "));
    }

    private void preencheCampos() {
        txfAltura.setText(String.valueOf(oldBaby.getHeight()));
        txfPeso.setText(String.valueOf(oldBaby.getWeight()));
        txtIdentificador.setText(oldBaby.getID());
        txtNome.setText(oldBaby.getName());
        cmbSexo.setSelectedItem(oldBaby.getSex());
        LocalDate dataNasc = oldBaby.getBirthday();
        txfDataNasc.setText(dataNasc.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    private Baby pegaDadosBebe() throws ValorInvalidoException {
        Baby baby = new Baby();
        StringBuilder msgErro = new StringBuilder();
        try {
            baby.setID(txtIdentificador.getText());
        } catch (ValorInvalidoException ex) {
            msgErro.append(ex.getMessage());
        }
        try {
            baby.setName(txtNome.getText());
        } catch (ValorInvalidoException ex) {
            if (msgErro.length() > 0) {
                msgErro.append("\n");
            }
            msgErro.append(ex.getMessage());
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataNasc = LocalDate.parse(txfDataNasc.getText(), formatter);
            baby.setBirthday(dataNasc);
        } catch (DateTimeParseException ex) {
            if (msgErro.length() > 0) {
                msgErro.append("\n");
            }
            msgErro.append("Data de nascimento do bebê inválida.");
        }
        try {
            String height = txfAltura.getText().replaceAll(",", ".");
            baby.setHeight(Double.parseDouble(height));
        } catch (ValorInvalidoException ex) {
            if (msgErro.length() > 0) {
                msgErro.append("\n");
            }
            msgErro.append(ex.getMessage());
        }
        try {
            String weight = txfPeso.getText().replaceAll(",", ".");
            baby.setWeight(Double.parseDouble(weight));
        } catch (ValorInvalidoException ex) {
            if (msgErro.length() > 0) {
                msgErro.append("\n");
            }
            msgErro.append(ex.getMessage());
        }
        baby.setSex(cmbSexo.getSelectedItem().toString());
        if (msgErro.length() == 0) {
            return baby;
        } else {
            throw new ValorInvalidoException(msgErro.toString());
        }
    }

    private void configComponents() {
        txtNome.setDocument(new JTextFieldLimit(Baby.TAM_MAX_NAME));
        txtIdentificador.setDocument(new JTextFieldLimit(Baby.TAM_MAX_ID));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cmbSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblAltura;
    private javax.swing.JLabel lblDataNasc;
    private javax.swing.JLabel lblIdentificador;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JFormattedTextField txfAltura;
    private javax.swing.JFormattedTextField txfDataNasc;
    private javax.swing.JFormattedTextField txfPeso;
    private javax.swing.JTextField txtIdentificador;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
