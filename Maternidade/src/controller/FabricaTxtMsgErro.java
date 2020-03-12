/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;

/**
 *
 * @author barab
 */
public class FabricaTxtMsgErro {

    public StringBuilder criarTxtErroCamposNaoPreench(ArrayList<String> nomesCamposNaoPreench) {
        final int quantMaxNomesPorLinha = 3;
        StringBuilder textoDaMensagemDeErro = new StringBuilder();
        if (nomesCamposNaoPreench.size() == 1) {
            textoDaMensagemDeErro.append("O seguinte campo não foi preenchido:\n");
        } else {
            textoDaMensagemDeErro.append("Os seguintes campos não foram "
                    + "preenchidos:\n");
        }
        int quantNomesAddAMsgErro = 0;
        for (String nome : nomesCamposNaoPreench) {
            if (quantNomesAddAMsgErro > 0) {
                if (quantNomesAddAMsgErro < (nomesCamposNaoPreench.size() - 1)) {
                    textoDaMensagemDeErro.append(", ");
                    if (quantNomesAddAMsgErro % quantMaxNomesPorLinha == 0) {
                        textoDaMensagemDeErro.append("\n");
                    }
                } else {
                    textoDaMensagemDeErro.append(" e ");
                    if (quantNomesAddAMsgErro % quantMaxNomesPorLinha == 0) {
                        textoDaMensagemDeErro.append("\n");
                    }
                }
            }
            textoDaMensagemDeErro.append(nome);
            quantNomesAddAMsgErro++;
        }
        return textoDaMensagemDeErro;
    }
}
