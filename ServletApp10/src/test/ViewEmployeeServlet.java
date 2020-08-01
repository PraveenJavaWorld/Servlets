package test;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
public class ViewEmployeeServlet extends GenericServlet{
	public Connection con;
	@Override
	public void init() throws ServletException{
		con=DBConnection.get();
	}
	@Override
	public void service(ServletRequest req,ServletResponse res)
	throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String id=req.getParameter("id");
		try{
			PreparedStatement ps=con.prepareStatement("select * from Employees16 where id=?");
			ps.setString(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				pw.println(rs.getString(1)+"&nbsp&nbsp"+rs.getString(2)+"&nbsp&nbsp"+rs.getString(3)+"&nbsp&nbsp"+rs.getFloat(4));
			}
			else{
				pw.println("Invalid Employee ID....");
			}
		}
		catch (Exception e) {
			
		}
	}

}
