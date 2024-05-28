package com.pwskills.nitin;

	import java.io.IOException;
	import java.sql.Connection;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Scanner;

	import com.pwskills.utility.DBUtil;

	public class UpdateApp {

		// private static final String SQLINSERT_QUERY = "insert into student values()";

		public static void main(String[] args) {
			
		//Resources used	
	     Connection connection = null;
	     Statement statement = null;
	     int rowCount = 0;
	     
	      try {
			connection =  DBUtil.getDBConnection();
			
			if( connection!= null)
					statement = connection.createStatement();
			
			Scanner scanner = new Scanner(System.in);
		
			String sqlUpdateQuery = null;
			if (scanner!=null) {
				System.out.print("Enter the  sid :: ");
				int sid = scanner.nextInt();
				System.out.print("Enter the  sname:: ");
				String sname = scanner.next();
				sname = "'" + sname + "'";
				
//				System.out.print("Enter the  sage :: ");
//				int sage = scanner.nextInt();
//				System.out.print("Enter the  saddress :: ");
//				String saddress = scanner.next();
//				saddress = "'" + saddress + "'";
				
				 sqlUpdateQuery = " update student set sname = "+sname+"where sid = "+sid+"";
				System.out.println(sqlUpdateQuery);
			}
			//System.in.read();
			if(statement!=null && sqlUpdateQuery != null)
					rowCount =statement.executeUpdate(sqlUpdateQuery);
			if(rowCount ==0)
				System.out.println("Record not available for updation....");
			else
				System.out.println("Record updated Sucessfully... ");
					
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}finally {
			DBUtil.cleanUpResources(null, statement, connection);
		}     
		}
	}

