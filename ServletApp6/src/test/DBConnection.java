package test;
import java.sql.*;
public class DBConnection {
	private static Connection con;
	private DBConnection(){} //constructor
	static{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		}
		catch (Exception e) {
			
		}
	}//end of static block
	public static Connection get(){ //static method
		return con;
	}
		
	

}
