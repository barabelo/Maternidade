/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

/**
 *
 * @author barab
 */
public class testeValidaTelefone {
    public static boolean isTelefone(String numeroTelefone) {
        return numeroTelefone.matches("(\\(?\\d{2}\\)?\\s)?(\\d{4,5}\\-\\d{4})");
    }
}
