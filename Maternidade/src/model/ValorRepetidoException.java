/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author barab
 */
public class ValorRepetidoException extends Exception {

    /**
     * Creates a new instance of <code>ChavePrimariaInvalidaException</code>
     * without detail message.
     */
    public ValorRepetidoException() {
    }

    /**
     * Constructs an instance of <code>ChavePrimariaInvalidaException</code>
     * with the specified detail message.
     *
     * @param msg the detail message.
     */
    public ValorRepetidoException(String msg) {
        super(msg);
    }
}
