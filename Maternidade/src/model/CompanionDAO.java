package model;

import controller.DBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanionDAO {

    public static void insert(Companion companion) throws ValorRepetidoException {
        if (MotherDAO.searchByCPF(companion.getCPF()) != null) {
            throw new ValorRepetidoException("Já existe outra pessoa "
                    + "com o mesmo CPF cadastrada no sistema.");
        } else if (MotherDAO.searchByRG(companion.getRG()) != null) {
            throw new ValorRepetidoException("Já existe outra pessoa "
                    + "com o mesmo RG cadastrada no sistema.");
        } else {
            Connection connection = new DBC().getConnection();
            PreparedStatement statement;
            String instruction = "INSERT INTO Companion (CPF, REG, companion_name, sex, kinship, email, phone, mother_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try {
                statement = connection.prepareStatement(instruction);
                statement.setString(1, companion.getCPF());
                statement.setString(2, companion.getRG());
                statement.setString(3, companion.getName());
                statement.setString(4, companion.getSex());
                statement.setString(5, companion.getKinship());
                statement.setString(6, companion.getEmail());
                statement.setString(7, companion.getPhone());
                statement.setString(8, companion.getMotherCPF());
                statement.execute();
                statement.close();
                connection.close();
            } catch (SQLException exception) {
                if (searchByCPF(companion.getCPF()) != null) {
                    throw new ValorRepetidoException("Já existe outra pessoa "
                            + "com o mesmo CPF cadastrada no sistema.");
                } else if (searchByRG(companion.getRG()) != null) {
                    throw new ValorRepetidoException("Já existe outra pessoa "
                            + "com o mesmo RG cadastrada no sistema.");
                } else {
                    throw new RuntimeException("Erro na inserção do acompanhante.\n"
                            + exception.getMessage());
                }
            }
        }
    }

    public static void update(Companion newCompanionData, String oldCompanionCPF) throws ValorRepetidoException {
        if (MotherDAO.searchByCPF(newCompanionData.getCPF()) != null) {
            throw new ValorRepetidoException("Já existe outra pessoa "
                    + "com o mesmo CPF cadastrada no sistema.");
        } else if (MotherDAO.searchByRG(newCompanionData.getRG()) != null) {
            throw new ValorRepetidoException("Já existe outra pessoa "
                    + "com o mesmo RG cadastrada no sistema.");
        } else {
            Connection connection = new DBC().getConnection();
            PreparedStatement statement;
            String instruction = "UPDATE Companion SET CPF = ?, REG = ?, companion_name = ?, sex = ?, kinship = ?, email = ?, phone = ? WHERE CPF = ?";
            try {
                statement = connection.prepareStatement(instruction);
                statement.setString(1, newCompanionData.getCPF());
                statement.setString(2, newCompanionData.getRG());
                statement.setString(3, newCompanionData.getName());
                statement.setString(4, newCompanionData.getSex());
                statement.setString(5, newCompanionData.getKinship());
                statement.setString(6, newCompanionData.getEmail());
                statement.setString(7, newCompanionData.getPhone());
                statement.setString(8, oldCompanionCPF);
                statement.execute();
                statement.close();
                connection.close();
            } catch (SQLException exception) {
                if (searchByCPF(newCompanionData.getCPF()) != null) {
                    throw new ValorRepetidoException("Já existe outro "
                            + "acompanhante com o mesmo CPF cadastrado no sistema.");
                } else if (searchByRG(newCompanionData.getRG()) != null) {
                    throw new ValorRepetidoException("Já existe outro "
                            + "acompanhante com o mesmo RG cadastrado no sistema.");
                } else {
                    throw new RuntimeException("Erro na edição do cadastro do "
                            + "acompanhante.\n" + exception.getMessage());
                }
            }
        }
    }

    public static Companion delete(String CPF) {
        Connection connection = new DBC().getConnection();
        Companion companion = new Companion();
        PreparedStatement statement;
        String instruction = "DELETE FROM Companion WHERE CPF = ?";

        try {
            statement = connection.prepareStatement(instruction);
            statement.setString(1, CPF);
            statement.execute();
            statement.close();
            connection.close();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro na exclusão do acompanhante.\n"
                    + exception.getMessage());
        }
        return companion;
    }

    public static Companion searchByCPF(String CPF) {
        Connection connection = new DBC().getConnection();
        Companion companion = new Companion();
        PreparedStatement statement;
        ResultSet result;
        String instruction = "SELECT * FROM Companion WHERE CPF = ?";

        try {
            statement = connection.prepareStatement(instruction);
            statement.setString(1, CPF);
            result = statement.executeQuery();
            if (result.next()) {
                companion.setCPF(CPF);
                companion.setRG(result.getString("REG"));
                companion.setName(result.getString("companion_name"));
                companion.setSex(result.getString("sex"));
                companion.setKinship(result.getString("kinship"));
                companion.setEmail(result.getString("email"));
                companion.setPhone(result.getString("phone"));
                companion.setMotherCPF(result.getString("mother_id"));
            } else {
                companion = null;
            }
            statement.close();
            connection.close();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro na seleção do acompanhante.\n"
                    + exception.getMessage());
        }
        return companion;
    }

    public static Companion searchByRG(String RG) {
        Connection connection = new DBC().getConnection();
        Companion companion = new Companion();
        PreparedStatement statement;
        ResultSet result;
        String instruction = "SELECT * FROM Companion WHERE REG = ?";

        try {
            statement = connection.prepareStatement(instruction);
            statement.setString(1, RG);
            result = statement.executeQuery();
            if (result.next()) {
                companion.setCPF(result.getString("CPF"));
                companion.setRG(RG);
                companion.setName(result.getString("companion_name"));
                companion.setSex(result.getString("sex"));
                companion.setKinship(result.getString("kinship"));
                companion.setEmail(result.getString("email"));
                companion.setPhone(result.getString("phone"));
                companion.setMotherCPF(result.getString("mother_id"));
            } else {
                companion = null;
            }
            statement.close();
            connection.close();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro na seleção do acompanhante.\n"
                    + exception.getMessage());
        }
        return companion;
    }

    public static Companion selectCompanionOf(String MotherCPF) {
        Connection connection = new DBC().getConnection();
        Companion companion = new Companion();
        PreparedStatement statement;
        ResultSet result;
        String instruction = "SELECT * FROM Companion WHERE mother_id = ?";

        try {
            statement = connection.prepareStatement(instruction);
            statement.setString(1, MotherCPF);
            result = statement.executeQuery();
            if (result.next()) {
                companion.setCPF(result.getString("CPF"));
                companion.setRG(result.getString("REG"));
                companion.setName(result.getString("companion_name"));
                companion.setSex(result.getString("sex"));
                companion.setKinship(result.getString("kinship"));
                companion.setEmail(result.getString("email"));
                companion.setPhone(result.getString("phone"));
                companion.setMotherCPF(MotherCPF);
            } else {
                companion = null;
            }
            statement.close();
            connection.close();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro na seleção do acompanhante.\n"
                    + exception.getMessage());
        }
        return companion;
    }
}
