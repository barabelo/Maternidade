package model;

import controller.DBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CompanionDAO {
	
	public static void insert(Companion companion) {
		
		Connection connection = new DBC().getConnection();
		
		PreparedStatement statement;
			
		String instruction = "INSERT INTO Companion (CPF, REG, companion_name, sex, kinship, email, phone, mother_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			
		try {
			
			statement = connection.prepareStatement(instruction);
				
			statement.setString(1, companion.getCPF());
			statement.setString(2, companion.getREG());
			statement.setString(3, companion.getName());
			statement.setString(4, companion.getSex());
			statement.setString(5, companion.getKinship());
			statement.setString(6, companion.getEmail());
			statement.setString(7, companion.getPhone());
			statement.setString(8, companion.getMCPF());
			
			statement.execute();
				
			connection.close();
				
		} catch (SQLException exception) {
			
			exception.printStackTrace();
		}
	}
	
	public static void update(Companion companion, String current, int option) {
		
		Connection connection = new DBC().getConnection();
		
		PreparedStatement statement;
	
		String instruction;
			
		try {
		
			switch(option) {

			case 1:
				instruction = "UPDATE Companion SET CPF = ?, REG = ?, companion_name = ?, sex = ?, kinship = ? WHERE CPF = ?";

				statement = connection.prepareStatement(instruction);

				statement.setString(1, companion.getCPF());
				statement.setString(2, companion.getREG());
				statement.setString(3, companion.getName());
				statement.setString(4, companion.getSex());
				statement.setString(5, companion.getKinship());
				statement.setString(6, current);

				statement.execute();

				break;
			case 2:
				instruction = "UPDATE Companion SET email = ?, phone = ? WHERE CPF = ?";

				statement = connection.prepareStatement(instruction);

				statement.setString(1, companion.getEmail());
				statement.setString(2, companion.getPhone());
				statement.setString(3, current);

				statement.execute();

				break;
			}

			connection.close();
			
		} catch (SQLException exception) {
			
			exception.printStackTrace();
		}
	}
	
	public static List <Companion> select(String CPF) {
		
		Connection connection = new DBC().getConnection();
		
		List <Companion> list = new ArrayList<>();
		
		PreparedStatement statement;
		
		ResultSet result;
	
		String instruction = "SELECT CPF, REG, companion_name, sex, kinship, email, phone FROM Companion WHERE mother_id = ?";
			
		try {
			
			statement = connection.prepareStatement(instruction);
			
			statement.setString(1,CPF);
			
			result = statement.executeQuery();
			
			while(result.next()) {
				
				Companion companion = new Companion();
				
				companion.setCPF(result.getString("CPF"));
				companion.setREG(result.getString("REG"));
				companion.setName(result.getString("companion_name"));
				companion.setSex(result.getString("sex"));
				companion.setKinship(result.getString("kinship"));
				companion.setEmail(result.getString("email"));
				companion.setPhone(result.getString("phone"));
				
				list.add(companion);
			}

			connection.close();
			
		} catch (SQLException exception) {
			
			exception.printStackTrace();
		}
		
		return list;
	}
}