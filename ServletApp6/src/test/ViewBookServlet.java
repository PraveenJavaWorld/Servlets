package test;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
public class ViewBookServlet extends GenericServlet{
	public Connection con;
	public void init() throws ServletException{
		con=DBConnection.get();
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String code=req.getParameter("code");
		try{
			PreparedStatement ps=con.prepareStatement("select * from Books16 where code=?");
			ps.setString(1,code);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				pw.println(rs.getString(1)+"&nbsp"+rs.getString(2)+"&nbsp"+rs.getString(3)+"&nbsp"+rs.getFloat(4)+"&nbsp"+rs.getInt(5));
			}//end of if
			else{
				pw.println("Invalid Book Code....");
			}
		}
		catch (Exception e) {
			
		}
		
	}
	

}
