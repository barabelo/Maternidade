package model;

import controller.DBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class MotherDoctorDAO {

    public static void insert(String CPF, String CRM) {

        Connection connection = new DBC().getConnection();

        PreparedStatement statement;

        String instruction = "INSERT INTO Mother_Doctor (Mother_CPF, Doctor_CRM) VALUES (?, ?)";

        try {

            statement = connection.prepareStatement(instruction);

            statement.setString(1, CPF);
            statement.setString(2, CRM);

            statement.execute();

            connection.close();

        } catch (SQLException exception) {

            exception.printStackTrace();
        }
    }
}
