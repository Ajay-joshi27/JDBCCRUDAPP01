package com.pwskills.nitin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.pwskills.utility.DBUtil;

public class SelectAndNonSelectApp {

	public static void main(String[] args) {

		// Resource used
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		int rowCount = 0;
		boolean flag = false;

		try {
			connection =  DBUtil.getDBConnection();

			if (connection != null)
				statement = connection.createStatement();

			Scanner scanner = new Scanner(System.in);

			String sqlQuery = null;
			if (scanner != null) {
				System.out.print("Enter the Query:: ");
				sqlQuery = scanner.nextLine();
				System.out.println(sqlQuery);
				scanner.close();
			}
			if (statement != null && sqlQuery != null)
				flag = statement.execute(sqlQuery);

			if (flag) {
				// Display resultSet
				resultSet = statement.getResultSet();
				while (resultSet.next())
					System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3)
							+ "\t" + resultSet.getString(4));
			} else {
				// Display Non-ResultSet
				rowCount = statement.getUpdateCount();
				if (rowCount == 0) {
					System.out.println("Table not modified...");
				} else {
					System.out.println("Table got modified....");
				}
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.cleanUpResources(null, statement, connection);
		}
	}
}
