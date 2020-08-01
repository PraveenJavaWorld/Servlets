package test;
import java.sql.*;
public class UserDAO {
	public boolean validate(String uname,String pass){
		try {
			Connection con=DriverConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from userreg16 where username=\'"+uname+"\'and password=\'"+pass+"\'");
			return rs.next();
		}//end of try
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
