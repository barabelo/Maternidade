package model;

import controller.DBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MotherDoctorDAO {

    public static void insert(MotherDoctor motherDoctor) {
        Connection connection = DBC.getConnection();
        PreparedStatement statement;
        String instruction = "INSERT INTO mother_doctor (Mother_CPF, Doctor_CRM) VALUES (?, ?)";
        try {
            statement = connection.prepareStatement(instruction);
            statement.setString(1, motherDoctor.getMotherCPF());
            statement.setString(2, motherDoctor.getDoctorCRM());
            statement.execute();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro na associação do médico à mãe"
                    + ex.getMessage());
        }
    }
    
    public static void delete(MotherDoctor motherDoctor) {
        Connection connection = DBC.getConnection();
        PreparedStatement statement;
        String instruction = "DELETE FROM mother_doctor WHERE Mother_CPF = ? AND Doctor_CRM = ?";
        try {
            statement = connection.prepareStatement(instruction);
            statement.setString(1, motherDoctor.getMotherCPF());
            statement.setString(2, motherDoctor.getDoctorCRM());
            statement.execute();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro na desassociação do médico à mãe"
                    + ex.getMessage());
        }
    }
}
