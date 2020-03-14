/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import model.ChavePrimInvalidException;
import model.Doctor;
import model.DoctorDAO;

/**
 *
 * @author barab
 */
public class MainTestes {

    public static void main(String args[]) throws ChavePrimInvalidException {
        Doctor doctor1 = new Doctor();
        doctor1.setName("Joaquim da Silva");
        doctor1.setCRM("1000");
        doctor1.setSpeciality("Otoingologista");
        DoctorDAO.insert(doctor1);
    }
}
