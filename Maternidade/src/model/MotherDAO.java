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
        if (CompanionDAO.searchByCPF(mother.getCPF()) != null) {
            throw new ValorRepetidoException("CPF da mãe inválido:\nJá existe "
                    + "outra pessoa cadastrada no sistema com o mesmo CPF.");
        } else if (CompanionDAO.searchByRG(mother.getREG()) != null) {
            throw new ValorRepetidoException("RG da mãe inválido:\nJá existe "
                    + "outra pessoa cadastrada no sistema com o mesmo RG.");
        } else {
            Connection connection = new DBC().getConnection();
            PreparedStatement statement;
            String instruction = "INSERT INTO Mother(CPF, REG, mother_name, "
                    + "birthday) VALUES (?, ?, ?, ?)";
            try {
                statement = connection.prepareStatement(instruction);
                statement.setString(1, mother.getCPF());
                statement.setString(2, mother.getREG());
                statement.setString(3, mother.getName());
                statement.setDate(4, Date.valueOf(mother.getBirthday()));
                statement.execute();
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                if (searchByCPF(mother.getCPF()) != null) {
                    throw new ValorRepetidoException("CPF da mãe inválido:\nJá "
                            + "existe outra pessoa cadastrada no sistema com o "
                            + "mesmo CPF.");
                } else if (searchByRG(mother.getREG()) != null) {
                    throw new ValorRepetidoException("RG da mãe inválido:\nJá "
                            + "existe outra pessoa cadastrada no sistema com o "
                            + "mesmo RG.");
                } else {
                    throw new RuntimeException("Erro na inserção da mãe.\n"
                            + ex.getMessage());
                }
            }
        }
    }

    public static void delete(String CPF) {
        Connection connection = new DBC().getConnection();
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
        if (CompanionDAO.searchByCPF(newMotherData.getCPF()) != null) {
            throw new ValorRepetidoException("CPF da mãe inválido:\nJá existe "
                    + "outra pessoa cadastrada no sistema com o mesmo CPF.");
        } else if (CompanionDAO.searchByRG(newMotherData.getREG()) != null) {
            throw new ValorRepetidoException("RG da mãe inválido:\nJá existe "
                    + "outra pessoa cadastrada no sistema com o mesmo RG.");
        } else {
            Connection connection = new DBC().getConnection();
            PreparedStatement statement;
            String instruction;
            try {
                instruction = "UPDATE Mother SET CPF = ?, REG = ?, "
                        + "mother_name = ?, birthday = ? WHERE CPF = ?";
                statement = connection.prepareStatement(instruction);
                statement.setString(1, newMotherData.getCPF());
                statement.setString(2, newMotherData.getREG());
                statement.setString(3, newMotherData.getName());
                statement.setDate(4, Date.valueOf(newMotherData.getBirthday()));
                statement.setString(5, oldMotherCPF);
                statement.execute();
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                if (searchByCPF(newMotherData.getCPF()) != null) {
                    throw new ValorRepetidoException("CPF da mãe inválido:\nJá "
                            + "existe outra pessoa cadastrada no sistema com o "
                            + "mesmo CPF.");
                } else if (searchByRG(newMotherData.getREG()) != null) {
                    throw new ValorRepetidoException("RG da mãe inválido:\nJá "
                            + "existe outra pessoa cadastrada no sistema com o "
                            + "mesmo RG.");
                } else {
                    throw new RuntimeException("Erro na edição do cadastro da "
                            + "mãe.\n" + ex.getMessage());
                }
            }
        }
    }

    public static List<Mother> selectAll() {
        Connection connection = new DBC().getConnection();
        List<Mother> mothers = new ArrayList<>();
        PreparedStatement statement;
        ResultSet result;
        String instruction = "SELECT * FROM mother";

        try {
            statement = connection.prepareStatement(instruction);
            result = statement.executeQuery();
            while (result.next()) {
                Mother mother = new Mother();
                mother.setBirthday(result.getDate("birthday").toLocalDate());
                mother.setName(result.getString("mother_name"));
                mother.setCPF(result.getString("CPF"));
                mother.setREG(result.getString("REG"));
                mothers.add(mother);
            }
            result.close();
            statement.close();
            connection.close();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao selecionar todas as mães.\n"
                    + exception.getMessage());
        }
        return mothers;
    }

    public static Mother searchByCPF(String CPF) {
        Connection connection = new DBC().getConnection();
        Mother mother = new Mother();
        PreparedStatement statement;
        ResultSet result;
        String instruction = "SELECT * FROM Mother WHERE CPF = ?";

        try {
            statement = connection.prepareStatement(instruction);
            statement.setString(1, CPF);
            result = statement.executeQuery();
            if (result.next()) {
                mother.setBirthday(result.getDate("birthday").toLocalDate());
                mother.setName(result.getString("mother_name"));
                mother.setCPF(CPF);
                mother.setREG(result.getString("REG"));
            } else {
                mother = null;
            }
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro na busca por CPF da mãe.\n"
                    + ex.getMessage());
        }
        return mother;
    }

    public static Mother searchByRG(String RG) {
        Connection connection = new DBC().getConnection();
        Mother mother = new Mother();
        PreparedStatement statement;
        ResultSet result;
        String instruction = "SELECT * FROM Mother WHERE REG = ?";

        try {
            statement = connection.prepareStatement(instruction);
            statement.setString(1, RG);
            result = statement.executeQuery();
            if (result.next()) {
                mother.setBirthday(result.getDate("birthday").toLocalDate());
                mother.setName(result.getString("mother_name"));
                mother.setCPF(result.getString("CPF"));
                mother.setREG(RG);
            } else {
                mother = null;
            }
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro na busca por RG da mãe.\n"
                    + ex.getMessage());
        }
        return mother;
    }
}
