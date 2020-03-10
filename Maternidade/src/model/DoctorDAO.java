package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.DBC;

public class DoctorDAO {

    public static void insert(Doctor doctor) {

        Connection connection = DBC.getInstance().getConnection();

        PreparedStatement statement;

        String instruction = "INSERT INTO Doctor (CRM, doctor_name, speciality) VALUES (?, ?, ?)";

        try {

            statement = connection.prepareStatement(instruction);

            statement.setString(1, doctor.getCRM());
            statement.setString(2, doctor.getName());
            statement.setString(3, doctor.getSpeciality());

            statement.execute();

            connection.close();

        } catch (SQLException exception) {

            exception.printStackTrace();
        }
    }

    public static void delete(String CRM) {

        Connection connection = DBC.getInstance().getConnection();

        PreparedStatement statement;

        String instruction = "DELETE FROM Doctor WHERE CRM = ?";

        try {

            statement = connection.prepareStatement(instruction);

            statement.setString(1, CRM);

            statement.execute();

            connection.close();

        } catch (SQLException exception) {

            exception.printStackTrace();
        }
    }

    public static List<Doctor> select(String CPF) {

        Connection connection = DBC.getInstance().getConnection();

        List<Doctor> list = new ArrayList<>();

        PreparedStatement statement;

        ResultSet result;

        String instruction = "SELECT Doctor.CRM, Doctor.doctor_name, Doctor.speciality FROM Mother INNER JOIN Mother_Doctor ON Mother.CPF = Mother_CPF INNER JOIN Doctor ON Doctor.CRM = Doctor_CRM WHERE Mother.CPF = ?";

        try {

            statement = connection.prepareStatement(instruction);

            statement.setString(1, CPF);

            result = statement.executeQuery();

            while (result.next()) {

                Doctor doctor = new Doctor();

                doctor.setCRM(result.getString("CRM"));
                doctor.setName(result.getString("doctor_name"));
                doctor.setSpeciality(result.getString("speciality"));

                list.add(doctor);
            }

            connection.close();

        } catch (SQLException exception) {

            exception.printStackTrace();
        }

        return list;
    }
}
