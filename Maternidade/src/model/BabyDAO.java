package model;

import controller.DBC;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BabyDAO {

    public static void insert(Baby baby) throws ValorRepetidoException {
        Connection connection = new DBC().getConnection();
        PreparedStatement statement;
        String instruction = "INSERT INTO Baby (baby_id, baby_name, birthday, sex, height, weight, mother_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            statement = connection.prepareStatement(instruction);
            statement.setString(1, baby.getID());
            statement.setString(2, baby.getName());
            statement.setDate(3, Date.valueOf(baby.getBirthday()));
            statement.setString(4, baby.getSex());
            statement.setDouble(5, baby.getHeight());
            statement.setDouble(6, baby.getWeight());
            statement.setString(7, baby.getMotherCPF());
            statement.execute();
            statement.close();
            connection.close();
        } catch (SQLException exception) {
            if (searchById(baby.getID()) != null) {
                throw new ValorRepetidoException("Já existe outro bebê "
                        + "com o mesmo id cadastrado no sistema.");
            }
            throw new RuntimeException("Erro na inserção do bebê.\n"
                    + exception.getMessage());
        }
    }

    public static void update(String oldBabyId, Baby newBabyData) throws ValorRepetidoException {
        Connection connection = new DBC().getConnection();
        PreparedStatement statement;
        String instruction = "UPDATE Baby SET baby_id = ?, baby_name = ?, birthday = ?, sex = ?, height = ?, weight = ? WHERE baby_id = ?";

        try {
            statement = connection.prepareStatement(instruction);
            statement.setString(1, newBabyData.getID());
            statement.setString(2, newBabyData.getName());
            statement.setDate(3, Date.valueOf(newBabyData.getBirthday()));
            statement.setString(4, newBabyData.getSex());
            statement.setDouble(5, newBabyData.getHeight());
            statement.setDouble(6, newBabyData.getWeight());
            statement.setString(7, oldBabyId);
            statement.execute();
            connection.close();
        } catch (SQLException exception) {
            if (searchById(newBabyData.getID()) != null) {
                throw new ValorRepetidoException("Já existe outro bebê "
                        + "com o mesmo id cadastrado no sistema.");
            }
            throw new RuntimeException("Erro na inserção do bebê.\n"
                    + exception.getMessage());
        }
    }

    public static Baby searchById(String id) {
        Connection connection = new DBC().getConnection();
        Baby baby = new Baby();
        PreparedStatement statement;
        ResultSet result;
        String instruction = "SELECT * FROM Baby WHERE baby_id = ?";

        try {
            statement = connection.prepareStatement(instruction);
            statement.setString(1, id);
            result = statement.executeQuery();
            if (result.next()) {
                baby.setID(id);
                baby.setName(result.getString("baby_name"));
                baby.setBirthday(result.getDate("birthday").toLocalDate());
                baby.setSex(result.getString("sex"));
                baby.setHeight(result.getDouble("height"));
                baby.setWeight(result.getDouble("weight"));
                baby.setMotherCPF(result.getString("mother_id"));
            } else {
                baby = null;
            }
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro na busca por id do bebê.\n"
                    + ex.getMessage());
        }
        return baby;
    }

    public static void delete(String id) {
        Connection connection = new DBC().getConnection();
        PreparedStatement statement;
        String instruction = "DELETE FROM Baby WHERE baby_id = ?";

        try {
            statement = connection.prepareStatement(instruction);
            statement.setString(1, id);
            statement.execute();
            statement.close();
            connection.close();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro na exclusão do bebê.\n"
                    + exception.getMessage());
        }
    }

    public static List<Baby> selectSonsOf(String MotherCPF) {
        Connection connection = new DBC().getConnection();
        List<Baby> babies = new ArrayList<>();
        PreparedStatement statement;
        ResultSet result;
        String instruction = "SELECT * FROM Baby WHERE mother_id = ?";

        try {
            statement = connection.prepareStatement(instruction);
            statement.setString(1, MotherCPF);
            result = statement.executeQuery();
            while (result.next()) {
                Baby baby = new Baby();
                baby.setID(result.getString("baby_id"));
                baby.setName(result.getString("baby_name"));
                baby.setBirthday(result.getDate("birthday").toLocalDate());
                baby.setSex(result.getString("sex"));
                baby.setHeight(result.getDouble("height"));
                baby.setWeight(result.getDouble("weight"));
                baby.setMotherCPF(MotherCPF);
                babies.add(baby);
            }
            statement.close();
            connection.close();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao selecionar os bebês.\n"
                    + exception.getMessage());
        }
        return babies;
    }
}
