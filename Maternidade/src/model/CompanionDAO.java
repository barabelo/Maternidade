package model;

import controller.DBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanionDAO {

    public static void insert(Companion companion) throws ValorRepetidoException {
        if (MotherDAO.searchByCPF(companion.getCpf()) != null) {
            throw new ValorRepetidoException("CPF do acompanhante inválido:\n"
                    + "Já existe outra pessoa cadastrada no sistema com o "
                    + "mesmo CPF.");
        } else if (MotherDAO.searchByRG(companion.getRg()) != null) {
            throw new ValorRepetidoException("RG do acompanhante inválido:\n"
                    + "Já existe outra pessoa cadastrada no sistema com o "
                    + "mesmo RG.");
        } else {
            Connection connection = new DBC().getConnection();
            PreparedStatement statement;
            String instruction = "INSERT INTO Companion (CPF, REG, "
                    + "companion_name, sex, kinship, email, phone, mother_id) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try {
                statement = connection.prepareStatement(instruction);
                statement.setString(1, companion.getCpf());
                statement.setString(2, companion.getRg());
                statement.setString(3, companion.getName());
                statement.setString(4, companion.getSex());
                statement.setString(5, companion.getKinship());
                statement.setString(6, companion.getEmail());
                statement.setString(7, companion.getPhone());
                statement.setString(8, companion.getMotherCpf());
                statement.execute();
                statement.close();
                connection.close();
            } catch (SQLException exception) {
                if (searchByCPF(companion.getCpf()) != null) {
                    throw new ValorRepetidoException("CPF do acompanhante "
                            + "inválido:\nJá existe outra pessoa cadastrada "
                            + "no sistema com o mesmo CPF.");
                } else if (searchByRG(companion.getRg()) != null) {
                    throw new ValorRepetidoException("RG do acompanhante "
                            + "inválido:\nJá existe outra pessoa cadastrada no "
                            + "sistema com o mesmo RG.");
                } else {
                    throw new RuntimeException("Erro na inserção do "
                            + "acompanhante.\n" + exception.getMessage());
                }
            }
        }
    }

    public static void update(String oldCompanionCPF, Companion newCompanionData) throws ValorRepetidoException {
        if (MotherDAO.searchByCPF(newCompanionData.getCpf()) != null) {
            throw new ValorRepetidoException("CPF do acompanhante inválido:\n"
                    + "Já existe outra pessoa cadastrada no sistema com o "
                    + "mesmo CPF.");
        } else if (MotherDAO.searchByRG(newCompanionData.getRg()) != null) {
            throw new ValorRepetidoException("RG do acompanhante inválido:\n"
                    + "Já existe outra pessoa cadastrada no sistema com o "
                    + "mesmo RG.");
        } else {
            Connection connection = new DBC().getConnection();
            PreparedStatement statement;
            String instruction = "UPDATE Companion SET CPF = ?, REG = ?, "
                    + "companion_name = ?, sex = ?, kinship = ?, email = ?, "
                    + "phone = ? WHERE CPF = ?";
            try {
                statement = connection.prepareStatement(instruction);
                statement.setString(1, newCompanionData.getCpf());
                statement.setString(2, newCompanionData.getRg());
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
                if (searchByCPF(newCompanionData.getCpf()) != null) {
                    throw new ValorRepetidoException("CPF do acompanhante "
                            + "inválido:\nJá existe outra pessoa cadastrada no "
                            + "sistema com o mesmo CPF.");
                } else if (searchByRG(newCompanionData.getRg()) != null) {
                    throw new ValorRepetidoException("RG do acompanhante "
                            + "inválido:\nJá existe outra pessoa cadastrada "
                            + "no sistema com o mesmo RG.");
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
                companion.setCpf(CPF);
                companion.setRg(result.getString("REG"));
                companion.setName(result.getString("companion_name"));
                companion.setSex(result.getString("sex"));
                companion.setKinship(result.getString("kinship"));
                companion.setEmail(result.getString("email"));
                companion.setPhone(result.getString("phone"));
                companion.setMotherCpf(result.getString("mother_id"));
            } else {
                companion = null;
            }
            statement.close();
            connection.close();
        } catch (SQLException | ValorInvalidoException ex) {
            throw new RuntimeException("Erro na seleção do acompanhante.\n"
                    + ex.getMessage());
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
                companion.setCpf(result.getString("CPF"));
                companion.setRg(RG);
                companion.setName(result.getString("companion_name"));
                companion.setSex(result.getString("sex"));
                companion.setKinship(result.getString("kinship"));
                companion.setEmail(result.getString("email"));
                companion.setPhone(result.getString("phone"));
                companion.setMotherCpf(result.getString("mother_id"));
            } else {
                companion = null;
            }
            statement.close();
            connection.close();
        } catch (SQLException | ValorInvalidoException ex) {
            throw new RuntimeException("Erro na seleção do acompanhante.\n"
                    + ex.getMessage());
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
                companion.setCpf(result.getString("CPF"));
                companion.setRg(result.getString("REG"));
                companion.setName(result.getString("companion_name"));
                companion.setSex(result.getString("sex"));
                companion.setKinship(result.getString("kinship"));
                companion.setEmail(result.getString("email"));
                companion.setPhone(result.getString("phone"));
                companion.setMotherCpf(MotherCPF);
            } else {
                companion = null;
            }
            statement.close();
            connection.close();
        } catch (SQLException | ValorInvalidoException ex) {
            throw new RuntimeException("Erro na seleção do acompanhante.\n"
                    + ex.getMessage());
        }
        return companion;
    }
}
