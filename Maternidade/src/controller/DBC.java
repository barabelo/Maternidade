/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author barab
 */
public class DBC {

    String database = "maternity_database";
    String url = "jdbc:mysql://localhost:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=true";
    String user = "maternidade";
    String password = "HXcFEFJgfD";

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            throw new RuntimeException("Falha na conexão ao banco de dados."
                    + ex.getMessage());
        }
    }
}
