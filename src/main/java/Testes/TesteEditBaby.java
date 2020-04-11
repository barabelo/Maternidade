/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import model.Baby;
import model.BabyDAO;
import view.TelaEditFilho;

/**
 *
 * @author barab
 */
public class TesteEditBaby {

    public static void main(String args[]) {
        Baby baby = BabyDAO.searchById("33333");
        TelaEditFilho telaEditFilho = new TelaEditFilho(null, true, baby);
        telaEditFilho.setLocationRelativeTo(null);
        telaEditFilho.setVisible(true);
    }
}
