package test;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
public class LoginServlet extends GenericServlet{
	public Connection con;
	@Override
	public void init() throws ServletException{
		con=DBConnection.getCon();
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		try {
			PreparedStatement ps=con.prepareStatement("select * from bookreg16 where username=? and password=?");
			ps.setString(1,username);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				pw.println("Welcome\t"+rs.getString(3)+"<br>");
				RequestDispatcher rd=req.getRequestDispatcher("link.html");
				rd.include(req, res);
			}
			else{
				pw.println("Invalid Username & Password");
				RequestDispatcher rd=req.getRequestDispatcher("login.html");
				rd.include(req, res);
			}
		} catch (Exception e) {
			
		}
		
	}

}
