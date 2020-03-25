/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import java.time.LocalDate;
import model.Mother;

/**
 *
 * @author barab
 */
public class MainTestes2 {

    public static void main(String args[]) {
//        Mother mae1 = new Mother();
//        mae1.setBirthday(LocalDate.now().plusDays(1));
//        mae1.setCPF("211.111.111-111");
//        mae1.setName("2");
//        mae1.setREG("21.111.111");
//        Mother mae2 = new Mother();
//        mae2.setBirthday(LocalDate.now());
//        mae2.setCPF("111.111.111-111");
//        mae2.setName("1");
//        mae2.setREG("11.111.111");
//        System.out.println(mae1.hashCode() == mae2.hashCode());
//        System.out.println(mae1.equals(mae2));
//        String before = " ";
//        String after = before.trim().replaceAll(" +", " ");
//        System.out.println(after + "a");
//        if (after.isEmpty()) {
//            System.out.println("Testes.MainTestes2.main()");
//        }

          String tel1 = "(35)123456789";
          String tel2 = "(35)12345678";
          String tel3 = "(35)12345 6789";
          String tel4 = "(35)1234 5678";
          System.out.println(testeValidaTelefone.isTelefone(tel1));
          System.out.println(testeValidaTelefone.isTelefone(tel2));
          System.out.println(testeValidaTelefone.isTelefone(tel3));
          System.out.println(testeValidaTelefone.isTelefone(tel4));
          
    }
    
}
