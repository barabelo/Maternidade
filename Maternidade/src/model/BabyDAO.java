package model;

import controller.DBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BabyDAO {
	
	public static void insert(Baby baby) {
		
		Connection connection = new DBC().getConnection();
		
		PreparedStatement statement;
			
		String instruction = "INSERT INTO Baby (baby_id, baby_name, birthday, sex, height, weight, mother_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
			
		try {
			
			statement = connection.prepareStatement(instruction);
				
			statement.setString(1, baby.getID());
			statement.setString(2, baby.getName());
			statement.setString(3, baby.getBirthday());
			statement.setString(4, baby.getSex());
			statement.setDouble(5, baby.getHeight());
			statement.setDouble(6, baby.getWeight());
			statement.setString(7, baby.getMCPF());
			
			statement.execute();
				
			connection.close();
				
		} catch (SQLException exception) {
			
			exception.printStackTrace();
		}
	}
	
	public static void update(Baby baby, String current) {
		
		Connection connection = new DBC().getConnection();
		
		PreparedStatement statement;
	
		String instruction = "UPDATE Baby SET baby_id = ?, baby_name = ?, birthday = ?, sex = ?, height = ?, weight = ? WHERE baby_id = ?";
			
		try {

			statement = connection.prepareStatement(instruction);
			
			statement.setString(1, baby.getID());
			statement.setString(2, baby.getName());
			statement.setString(3, baby.getBirthday());
			statement.setString(4, baby.getSex());
			statement.setDouble(5, baby.getHeight());
			statement.setDouble(6, baby.getWeight());
			statement.setString(7, current);
			
			statement.execute();

			connection.close();
			
		} catch (SQLException exception) {
			
			exception.printStackTrace();
		}
	}
	
	public static List <Baby> select(String CPF) {
		
		Connection connection = new DBC().getConnection();
		
		List <Baby> list = new ArrayList<>();
		
		PreparedStatement statement;
		
		ResultSet result;
	
		String instruction = "SELECT baby_id, baby_name, birthday, sex, height, weight FROM Baby WHERE mother_id = ?";
			
		try {
			
			statement = connection.prepareStatement(instruction);
			
			statement.setString(1,CPF);
			
			result = statement.executeQuery();
			
			while(result.next()) {
				
				Baby baby = new Baby();
				
				baby.setID(result.getString("baby_id"));
				baby.setName(result.getString("baby_name"));
				baby.setBirthday(result.getString("birthday"));
				baby.setSex(result.getString("sex"));
				baby.setHeight(result.getDouble("height"));
				baby.setWeight(result.getDouble("weight"));
				
				list.add(baby);
			}

			connection.close();
			
		} catch (SQLException exception) {
			
			exception.printStackTrace();
		}
		
		return list;
	}
}
