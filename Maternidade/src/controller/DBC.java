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

    private static final String DATABASE = "maternity_database";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DATABASE + "?useTimezone=true&serverTimezone=UTC&useSSL=true";
    private static final String USER = "maternidade";
    private static final String PASSWORD = "HXcFEFJgfD";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            throw new RuntimeException("Falha na conexão ao banco de dados."
                    + ex.getMessage());
        }
    }
}
