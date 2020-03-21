/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import java.time.LocalDate;
import java.util.List;
import model.Baby;
import model.BabyDAO;
import model.ValorRepetidoException;
import model.Companion;
import model.CompanionDAO;
import model.Doctor;
import model.DoctorDAO;
import model.Mother;
import model.MotherDAO;

/**
 *
 * @author barab
 */
public class MainTestes {
    
    public static void main(String args[]) throws ValorRepetidoException {
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
//        mother.setBirthday(LocalDate.now().plusDays(5));
//        mother.setREG("22.222.222");
//        mother.setName("2");
//        MotherDAO.insert(mother);
//        mother.setCPF("333.333.333-33");
//        mother.setBirthday(LocalDate.now().plusDays(10));
//        mother.setREG("33.333.333");
//        mother.setName("3");
//        MotherDAO.insert(mother);
//        mother.setCPF("444.444.444-44");
//        mother.setBirthday(LocalDate.now().plusDays(15));
//        mother.setREG("44.444.444");
//        mother.setName("4");
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
//        List<Mother> mothers = MotherDAO.selectSonsOf();
//        for (Mother mother1 : mothers) {
//            System.out.println(mother1.getCPF());
//        }
//        Baby baby = new Baby();
//        baby.setBirthday(LocalDate.now());
//        baby.setHeight(50);
//        baby.setID("25");
//        baby.setMotherCPF("111.111.111-11");
//        baby.setName("a");
//        baby.setSex("Masculino");
//        baby.setWeight(1000);
//        BabyDAO.insert(baby);
//        baby.setBirthday(LocalDate.now().plusDays(2));
//        baby.setHeight(45);
//        baby.setID("300");
//        baby.setMotherCPF("222.222.222-22");
//        baby.setName("b");
//        baby.setSex("Feminino");
//        baby.setWeight(1105);
//        BabyDAO.insert(baby);
//        baby.setBirthday(LocalDate.now().plusDays(2));
//        baby.setHeight(56);
//        baby.setID("290");
//        baby.setMotherCPF("111.111.111-11");
//        baby.setName("c");
//        baby.setSex("Feminino");
//        baby.setWeight(1120);
//        BabyDAO.insert(baby);
//        baby = BabyDAO.searchById("25");
//        System.out.println(baby.getName());
//        baby = BabyDAO.searchById("250");
//        System.out.println(baby);
//        baby = BabyDAO.searchById("300");
//        System.out.println(baby.getName());
//        List<Baby> babies = BabyDAO.selectSonsOf("111.111.111-11");
//        for (Baby baby1 : babies) {
//            System.out.println(baby1.getName());
//        }
//        baby.setBirthday(LocalDate.now().plusMonths(15));
//        baby.setHeight(70);
//        baby.setID("400");
//        baby.setMotherCPF("222.222.222-22");
//        baby.setName("d");
//        baby.setSex("Masculino");
//        baby.setWeight(1300);
//        BabyDAO.update("290", baby);
//        BabyDAO.delete("300");
//        MotherDAO.delete("111.111.111-11");

//        Companion companion = new Companion();
//        companion.setCPF("123.456.789-01");
//        companion.setEmail("comp1@email.com");
//        companion.setKinship("Marido");
//        companion.setMotherCPF("111.111.111-11");
//        companion.setName("a");
//        companion.setPhone("91111-1111");
//        companion.setRG("12.345.678");
//        companion.setSex("Masculino");
//        CompanionDAO.insert(companion);
//        String oldCompanionCPF = companion.getCPF();
//        companion.setCPF("987.654.321-09");
//        companion.setEmail("comp1@uol.com");
//        companion.setKinship("Mãe");
//        companion.setMotherCPF("222.222.222-22");
//        companion.setName("b");
//        companion.setPhone("92222-2222");
//        companion.setRG("98.765.432");
//        companion.setSex("Feminino");
//        CompanionDAO.update(companion, oldCompanionCPF);
//        CompanionDAO.delete("987.654.321-09");
//        MotherDAO.delete("111.111.111-11");
    }
}
