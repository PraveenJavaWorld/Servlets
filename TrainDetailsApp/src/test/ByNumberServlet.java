package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
public class ByNumberServlet extends GenericServlet{
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
		long number=Long.parseLong(req.getParameter("number"));
		RequestDispatcher rd=req.getRequestDispatcher("Link.html");
		rd.include(req, res);
		pw.println("<br>");
		try{
			PreparedStatement ps=con.prepareStatement("select * from trains16 where trainnumber=?");
			ps.setLong(1,number);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				pw.println("<br>---Train Details---<br>");
				pw.println(rs.getLong(1)+"&nbsp&nbsp"+rs.getString(2)+"&nbsp&nbsp"+rs.getString(3)+"&nbsp&nbsp"+rs.getString(4)+"&nbsp&nbsp"+rs.getString(5));
			}
			else{
				pw.println("Invalid Train-Number....<br>");
				RequestDispatcher rd1=req.getRequestDispatcher("Train.html");
				rd1.include(req, res);;
			}
		}
		catch (Exception e) {
			
		}
		
	}

}
