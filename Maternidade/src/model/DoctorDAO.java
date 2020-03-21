package model;

import controller.DBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    public static void insert(Doctor doctor) throws ValorRepetidoException {
        Connection connection = new DBC().getConnection();
        PreparedStatement statement;
        String instruction = "INSERT INTO Doctor (CRM, doctor_name, speciality) VALUES (?, ?, ?)";
        try {
            statement = connection.prepareStatement(instruction);
            statement.setString(1, doctor.getCRM());
            statement.setString(2, doctor.getName());
            statement.setString(3, doctor.getSpeciality());
            statement.execute();
            statement.close();
            connection.close();
        } catch (SQLException exception) {
            if (searchByCRM(doctor.getCRM()) != null) {
                throw new ValorRepetidoException("Já existe outro médico "
                        + "com o mesmo CRM cadastrado no sistema.");
            } else {
                throw new RuntimeException("Erro na inserção do médico.\n"
                        + exception.getMessage());
            }
        }
    }

    public static void delete(String CRM) {
        Connection connection = new DBC().getConnection();
        PreparedStatement statement;
        String instruction = "DELETE FROM Doctor WHERE CRM = ?";

        try {
            statement = connection.prepareStatement(instruction);
            statement.setString(1, CRM);
            statement.execute();
            statement.close();
            connection.close();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro na exclusão do médico.\n"
                    + exception.getMessage());
        }
    }

    public static Doctor searchByCRM(String CRM) {
        Connection connection = new DBC().getConnection();
        Doctor doctor = new Doctor();
        PreparedStatement statement;
        ResultSet result;
        String instruction = "SELECT * FROM Doctor WHERE CRM = ?";

        try {
            statement = connection.prepareStatement(instruction);
            statement.setString(1, CRM);
            result = statement.executeQuery();
            if (result.next()) {
                doctor.setCRM(CRM);
                doctor.setName(result.getString("doctor_name"));
                doctor.setSpeciality(result.getString("speciality"));
            } else {
                doctor = null;
            }
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro na busca por CRM do médico.\n"
                    + ex.getMessage());
        }
        return doctor;
    }

    public static List<Doctor> selectAll() {
        Connection connection = new DBC().getConnection();
        List<Doctor> doctors = new ArrayList<>();
        PreparedStatement statement;
        ResultSet result;
        String instruction = "SELECT * FROM doctor";

        try {
            statement = connection.prepareStatement(instruction);
            result = statement.executeQuery();
            while (result.next()) {
                Doctor doctor = new Doctor();
                doctor.setCRM(result.getString("CRM"));
                doctor.setName(result.getString("doctor_name"));
                doctor.setSpeciality(result.getString("speciality"));
                doctors.add(doctor);
            }
            result.close();
            statement.close();
            connection.close();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao selecionar todos os médicos.\n"
                    + exception.getMessage());
        }
        return doctors;
    }

    public static List<Doctor> selectResponsibleFor(String MotherCPF) {

        Connection connection = new DBC().getConnection();
        List<Doctor> doctorList = new ArrayList<>();
        PreparedStatement statement;
        ResultSet result;
        String instruction = "SELECT Doctor.CRM, Doctor.doctor_name, Doctor.speciality FROM Mother INNER JOIN Mother_Doctor ON Mother.CPF = Mother_CPF INNER JOIN Doctor ON Doctor.CRM = Doctor_CRM WHERE Mother.CPF = ?";

        try {
            statement = connection.prepareStatement(instruction);
            statement.setString(1, MotherCPF);
            result = statement.executeQuery();

            while (result.next()) {
                Doctor doctor = new Doctor();
                doctor.setCRM(result.getString("CRM"));
                doctor.setName(result.getString("doctor_name"));
                doctor.setSpeciality(result.getString("speciality"));
                doctorList.add(doctor);
            }
            result.close();
            statement.close();
            connection.close();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao selecionar os médicos "
                    + "responsáveis pela mãe.\n" + exception.getMessage());
        }
        return doctorList;
    }
}
