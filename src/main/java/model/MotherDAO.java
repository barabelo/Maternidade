package model;

import controller.DBC;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MotherDAO {

    public static void insert(Mother mother) throws ValorRepetidoException {
        if (CompanionDAO.searchByCPF(mother.getCpf()) != null) {
            throw new ValorRepetidoException("CPF da mãe inválido:\nJá existe "
                    + "outra pessoa cadastrada no sistema com o mesmo CPF.");
        } else {
            Connection connection = DBC.getConnection();
            PreparedStatement statement;
            String instruction = "INSERT INTO Mother(CPF, REG, mother_name, "
                    + "birthday) VALUES (?, ?, ?, ?)";
            try {
                statement = connection.prepareStatement(instruction);
                statement.setString(1, mother.getCpf());
                statement.setString(2, mother.getRg());
                statement.setString(3, mother.getName());
                statement.setDate(4, Date.valueOf(mother.getBirthday()));
                statement.execute();
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                if (searchByCPF(mother.getCpf()) != null) {
                    throw new ValorRepetidoException("CPF da mãe inválido:\nJá "
                            + "existe outra pessoa cadastrada no sistema com o "
                            + "mesmo CPF.");
                } else {
                    throw new RuntimeException("Erro na inserção da mãe.\n"
                            + ex.getMessage());
                }
            }
        }
    }

    public static void delete(String CPF) {
        Connection connection = DBC.getConnection();
        PreparedStatement statement;
        String instruction = "DELETE FROM Mother WHERE CPF = ?";
        try {
            statement = connection.prepareStatement(instruction);
            statement.setString(1, CPF);
            statement.execute();
            statement.close();
            connection.close();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro na exclusão da mãe.\n"
                    + exception.getMessage());
        }
    }

    public static void update(String oldMotherCPF, Mother newMotherData) throws ValorRepetidoException {
        if (CompanionDAO.searchByCPF(newMotherData.getCpf()) != null) {
            throw new ValorRepetidoException("CPF da mãe inválido:\nJá existe "
                    + "outra pessoa cadastrada no sistema com o mesmo CPF.");
        } else {
            Connection connection = DBC.getConnection();
            PreparedStatement statement;
            String instruction;
            try {
                instruction = "UPDATE Mother SET CPF = ?, REG = ?, "
                        + "mother_name = ?, birthday = ? WHERE CPF = ?";
                statement = connection.prepareStatement(instruction);
                statement.setString(1, newMotherData.getCpf());
                statement.setString(2, newMotherData.getRg());
                statement.setString(3, newMotherData.getName());
                statement.setDate(4, Date.valueOf(newMotherData.getBirthday()));
                statement.setString(5, oldMotherCPF);
                statement.execute();
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                if (searchByCPF(newMotherData.getCpf()) != null) {
                    throw new ValorRepetidoException("CPF da mãe inválido:\nJá "
                            + "existe outra pessoa cadastrada no sistema com o "
                            + "mesmo CPF.");
                } else {
                    throw new RuntimeException("Erro na edição do cadastro da "
                            + "mãe.\n" + ex.getMessage());
                }
            }
        }
    }

    public static List<Mother> selectAll() {
        Connection connection = DBC.getConnection();
        List<Mother> mothers = new ArrayList<>();
        PreparedStatement statement;
        ResultSet result;
        String instruction = "SELECT * FROM mother";
        try {
            statement = connection.prepareStatement(instruction);
            result = statement.executeQuery();
            while (result.next()) {
                Mother mother = new Mother();
                mother.setBirthday(result.getDate("birthday").toLocalDate().plusDays(1));
                mother.setName(result.getString("mother_name"));
                mother.setCpf(result.getString("CPF"));
                mother.setRg(result.getString("REG"));
                mothers.add(mother);
            }
            result.close();
            statement.close();
            connection.close();
        } catch (SQLException | ValorInvalidoException ex) {
            throw new RuntimeException("Erro ao selecionar todas as mães.\n"
                    + ex.getMessage());
        }
        return mothers;
    }

    public static Mother searchByCPF(String CPF) {
        Connection connection = DBC.getConnection();
        Mother mother = new Mother();
        PreparedStatement statement;
        ResultSet result;
        String instruction = "SELECT * FROM Mother WHERE CPF = ?";
        try {
            statement = connection.prepareStatement(instruction);
            statement.setString(1, CPF);
            result = statement.executeQuery();
            if (result.next()) {
                mother.setBirthday(result.getDate("birthday").toLocalDate().plusDays(1));
                mother.setName(result.getString("mother_name"));
                mother.setCpf(CPF);
                mother.setRg(result.getString("REG"));
            } else {
                mother = null;
            }
            statement.close();
            connection.close();
        } catch (SQLException | ValorInvalidoException ex) {
            throw new RuntimeException("Erro na busca por CPF da mãe.\n"
                    + ex.getMessage());
        }
        return mother;
    }
}
