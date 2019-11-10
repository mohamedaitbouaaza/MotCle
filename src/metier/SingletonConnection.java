import metier ;

import java.sql.Connection;
import java.sql.DriverManager;


public class SingletonConnection {
   public static Connection getConnection() {
		return connection;
	}
private static Connection connection ; 
   static { 
	   try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection	
	("jdbc:mysql://localhost:3306/base","root","");
		      
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
}
