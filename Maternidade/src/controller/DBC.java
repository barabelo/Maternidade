package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBC {

    private static DBC instance;

    private static final String ADRESS = "jdbc:mysql://localhost:3306/maternity_database?useTimezone=true&serverTimezone=UTC";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public Connection getConnection() {

        Connection connection = null;

        try {

            Class.forName(DRIVER);

            connection = DriverManager.getConnection(ADRESS, USER, PASSWORD);

        } catch (ClassNotFoundException | SQLException exception) {

            exception.printStackTrace();
        }

        return connection;
    }

    public static DBC getInstance() {

        if (instance == null) {
            instance = new DBC();
        }

        return instance;
    }
}
