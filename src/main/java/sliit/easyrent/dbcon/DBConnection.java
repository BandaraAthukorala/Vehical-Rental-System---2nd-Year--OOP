package sliit.easyrent.dbcon;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
private static Connection connection;
	
	private DBConnection() {
		
	}
	public static Connection getConnection()  {
		if(connection==null) {
			
			//using the jdbc driver
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		
	        
			//connecting to the mysql db
	        try {
	        	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyrentdb?useSSL=false", "root", "root");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return connection;
	}
}
