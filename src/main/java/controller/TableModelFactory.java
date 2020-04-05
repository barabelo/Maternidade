/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Doctor;
import model.Mother;

/**
 *
 * @author barab
 */
public class TableModelFactory {

    public static DefaultTableModel criarTblModelMedicos(List<Doctor> doctors) {
        Object[][] dados = new Object[doctors.size()][3];
        for (int i = 0; i < doctors.size(); i++) {
            Doctor doctor = doctors.get(i);
            dados[i][0] = doctor.getName();
            dados[i][1] = doctor.getSpeciality();
            dados[i][2] = doctor.getCrm();
        }
        Object[] nomesColunas = {"Nome", "Especialidade", "CRM"};
        DefaultTableModel modelo = new DefaultTableModel(dados, nomesColunas) {
            boolean[] canEdit = new boolean[]{
                false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        return modelo;
    }
    
    public static DefaultTableModel criarTblModelMaesSimplificada(List<Mother> mothers) {
        Object[][] dados = new Object[mothers.size()][3];
        for (int i = 0; i < mothers.size(); i++) {
            Mother mother = mothers.get(i);
            dados[i][0] = mother.getName();
            dados[i][1] = mother.getCpf();
            dados[i][2] = mother.getRg();
        }
        Object[] nomesColunas = {"Nome", "CPF", "RG"};
        DefaultTableModel modelo = new DefaultTableModel(dados, nomesColunas) {
            boolean[] canEdit = new boolean[]{
                false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        return modelo;
    }
}
