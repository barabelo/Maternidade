/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import model.ValorInvalidoException;
import view.TelaAddFilho;

/**
 *
 * @author barab
 */
public class TesteAddBaby {

    public static void main(String args[]) throws ValorInvalidoException {
        TelaAddFilho telaAddFilho = new TelaAddFilho(null, true, "999.999.999-99");
        telaAddFilho.setLocationRelativeTo(null);
        telaAddFilho.setVisible(true);
    }
}
