package com.pwskills.nitin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.pwskills.utility.DBUtil;


public class SelectApp {

	public static void main(String[] args) {
		
		
		//Resources used
		Connection connection = null;
		Statement  statement  = null;
		ResultSet  resultSet  = null;
		
		
		try {
			
			
		
	connection = DBUtil.getDBConnection();
	// System.out.println("Connection established for :: "+url);
	//System.out.println("Connection :: "+connection.getClass().getName());
	
	//2.Create a statement object
    statement = connection.createStatement();
	// System.out.println("\n Statement object created..");
	// System.out.println("Connection ::" + connection.getClass().getName());
	
	//3. Execute the query
	String SqlSelectQuery="select sid,sname,sage,saddress from student";
	resultSet = statement.executeQuery(SqlSelectQuery);
	// System.out.println("\nResultSet Object created....");
	// System.out.println("ResultSet ::" + resultSet.getClass().getName());
	
	
	//4. Process the Result
	System.out.println("SID\tSNAME\tSAGE\tSADDRESS");
	while(resultSet.next()) {
		int sid=resultSet.getInt(1);
		String sname = resultSet.getString(2);
		int sage = resultSet.getInt(3);
		String saddress = resultSet.getString(4);
		System.out.println(sid+"\t"+sname+"\t"+sage+"\t"+saddress);
	}
		//5. Close the resources
		
	}catch (SQLException e) {
		e.printStackTrace();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		
		DBUtil.cleanUpResources(resultSet, statement, connection);
		
		
	 }

   }
}





