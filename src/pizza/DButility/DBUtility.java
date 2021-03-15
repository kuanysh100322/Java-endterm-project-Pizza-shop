package pizza.DButility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtility 
{
     public static Connection getConnection()
     {
    	 Connection con=null;
    	 try
    	 {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/onlinepizzaorder?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
		 } 
    	 
    	 catch (Exception e)
    	 {
			e.printStackTrace();
	   	}
    	 return con;
     }
}
