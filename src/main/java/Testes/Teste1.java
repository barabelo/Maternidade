/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import model.Baby;
import model.ValorInvalidoException;

/**
 *
 * @author barab
 */
public class Teste1 {

    /**
     *
     * @param args
     */
    public static void main(String args[]) {
        Baby baby = new Baby();
        try {
            baby.setID("11111");
        } catch (ValorInvalidoException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
