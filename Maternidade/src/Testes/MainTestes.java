/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import java.time.LocalDate;
import java.util.List;
import model.ChavePrimInvalidException;
import model.Doctor;
import model.DoctorDAO;
import model.Mother;
import model.MotherDAO;

/**
 *
 * @author barab
 */
public class MainTestes {

    public static void main(String args[]) throws ChavePrimInvalidException {
//        Doctor doctor1 = new Doctor();
//        doctor1.setName("Joaquim da Silva");
//        doctor1.setCRM("1000");
//        doctor1.setSpeciality("Otoingologista");
//        DoctorDAO.insert(doctor1);
//
//        Mother mother = new Mother();
//        mother.setCPF("111.111.111-11");
//        mother.setBirthday(LocalDate.now());
//        mother.setREG("11.111.111");
//        mother.setName("1");
//        MotherDAO.insert(mother);
//        mother.setCPF("222.222.222-22");
//        mother.setBirthday(LocalDate.now().plusYears(10));
//        mother.setREG("22.222.222");
//        mother.setName("2");
//        MotherDAO.insert(mother);
//        MotherDAO.delete("111.111.111-11");
//        System.out.println(MotherDAO.searchByCPF("111.111.111-11").getCPF());
//        System.out.println(MotherDAO.searchByCPF("222.222.222-22").getCPF());
//        System.out.println(MotherDAO.searchByCPF("333.333.333-33"));
//        mother.setCPF("333.333.333-33");
//        mother.setBirthday(LocalDate.now().plusYears(100));
//        mother.setREG("33.333.33");
//        mother.setName("3");
//        MotherDAO.update("111.111.111-11", mother);
//        MotherDAO.update("555.555.555-55", mother);
        List<Mother> mothers = MotherDAO.selectAll();
        for (Mother mother1 : mothers) {
            System.out.println(mother1.getCPF());
        }
    }
}
