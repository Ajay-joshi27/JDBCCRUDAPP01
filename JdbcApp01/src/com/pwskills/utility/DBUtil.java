package com.pwskills.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public final class DBUtil {

	private DBUtil() {
	}
	static Properties properties = null;
	static {
		FileInputStream fis = null;
		
		String fileInfo="A:\\eclipse-workspace\\JdbcApp01\\src\\com\\pwskills\\properties\\database.properties";
		try {
			fis = new FileInputStream(fileInfo);
			properties = new Properties();
			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}	finally {
			if(fis!=null) {
				try {
					fis.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static Connection getDBConnection() throws SQLException, IOException {
		//1. Establishing the connection
	
		return  DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"),
			 properties.getProperty("password"));
		
			
	}
	
	public static void cleanUpResources(ResultSet resultSet, Statement statement,Connection connection) {
	// 5.Close the resources
	
			if(resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			// closing statement
			if(statement != null) {
				try {
					statement.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
			// closing the connection
			
			if(connection !=null) {
				try {
					connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
	
			}
	}
}

