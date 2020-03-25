/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import java.time.LocalDate;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
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

//        String tel1 = "(11) 11111-1111";
//        String tel2 = "(11) 1111-1111";
//        String tel3 = "11 11111-1111";
//        String tel4 = "11 1111-1111";
//        String tel5 = "11111-1111";
//        String tel6 = "1111-1111";
//        System.out.println(testeValidaTelefone.isTelefone(tel1));
//        System.out.println(testeValidaTelefone.isTelefone(tel2));
//        System.out.println(testeValidaTelefone.isTelefone(tel3));
//        System.out.println(testeValidaTelefone.isTelefone(tel4));
//        System.out.println(testeValidaTelefone.isTelefone(tel5));
//        System.out.println(testeValidaTelefone.isTelefone(tel6));

        String mensagem = "Linha 1" + "\n" + "Linha 2";
//        JOptionPane.showMessageDialog (null, mensagem);
        // Segunda forma - usando HTML
        mensagem = "<html><u>Linha 1</u>" + "<br/>" + "<i>Linha 2</i></html> + <html><u>Linha 3</u>" + "<br/>" + "<i>Linha 4</i></html>";
        JOptionPane.showMessageDialog (null, mensagem);
    }

}
