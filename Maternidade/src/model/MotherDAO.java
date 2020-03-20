package model;

import controller.DBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MotherDAO {

    public static void insert(Mother mother) {

        Connection connection = new DBC().getConnection();

        PreparedStatement statement;

        String instruction = "INSERT INTO Mother(CPF, REG, mother_name, birthday) VALUES (?, ?, ?, ?)";

        try {

            statement = connection.prepareStatement(instruction);

            statement.setString(1, mother.getCPF());
            statement.setString(2, mother.getREG());
            statement.setString(3, mother.getName());
            statement.setString(4, mother.getBirthday());

            statement.execute();

            connection.close();

        } catch (SQLException exception) {

            exception.printStackTrace();
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

            connection.close();

        } catch (SQLException exception) {

            exception.printStackTrace();
        }
    }

    public static void update(Mother mother, String current) {

        Connection connection = new DBC().getConnection();

        PreparedStatement statement;

        String instruction;

        try {

            instruction = "UPDATE Mother SET CPF = ?, REG = ?, mother_name = ?, birthday = ? WHERE CPF = ?";

            statement = connection.prepareStatement(instruction);

            statement.setString(1, mother.getCPF());
            statement.setString(2, mother.getREG());
            statement.setString(3, mother.getName());
            statement.setString(4, mother.getBirthday());
            statement.setString(5, current);

            statement.execute();

            connection.close();

        } catch (SQLException exception) {

            exception.printStackTrace();
        }
    }

    public static List<Mother> select(String CPF) {

        Connection connection = new DBC().getConnection();

        List<Mother> list = new ArrayList<>();

        PreparedStatement statement;

        ResultSet result;

        String instruction = "SELECT * FROM Mother WHERE CPF = ?";

        try {

            statement = connection.prepareStatement(instruction);

            statement.setString(1, CPF);

            result = statement.executeQuery();

            while (result.next()) {

                Mother mother = new Mother();

                mother.setCPF(result.getString("CPF"));
                mother.setREG(result.getString("REG"));
                mother.setName(result.getString("mother_name"));
                mother.setBirthday(result.getString("birthday"));

                list.add(mother);
            }

            connection.close();

        } catch (SQLException exception) {

            exception.printStackTrace();
        }

        return list;
    }
}
