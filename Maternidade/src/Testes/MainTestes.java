/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import model.Doctor;
import model.DoctorDAO;

/**
 *
 * @author barab
 */
public class MainTestes {
    public static void main(String args[]) {
        Doctor doctor = DoctorDAO.searchByCRM("555");
        System.out.println(doctor.getName());
        Doctor doctor2 = DoctorDAO.searchByCRM("400");
        System.out.println(doctor2);
        Doctor doctor3 = DoctorDAO.searchByCRM("900");
        System.out.println(doctor3.getName());
    }
}
