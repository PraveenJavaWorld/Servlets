package test;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
public class RegServlet extends GenericServlet{
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
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String fname=req.getParameter("fname");
		String lname=req.getParameter("lname");
		String mailid=req.getParameter("mailid");
		long phonenumber=Long.parseLong(req.getParameter("phonenumber"));
		try {
			PreparedStatement ps=con.prepareStatement("insert into userreg16 values(?,?,?,?,?,?)");
			ps.setString(1,username);
			ps.setString(2,password);
			ps.setString(3,fname);
			ps.setString(4,lname);
			ps.setString(5,mailid);
			ps.setLong(6,phonenumber);
			int k=ps.executeUpdate();
			if(k>0){
				pw.println("<br>User Registered Succeesfully...<br>");
				pw.println("<br>");
				RequestDispatcher rd=req.getRequestDispatcher("Login.html");
				rd.include(req, res);
			}
		} catch (Exception e) {
			
		}
	}

}
