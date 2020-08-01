package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
public class AddStudentServlet extends GenericServlet{
	public void init() throws ServletException{
		
	}
	public void service(ServletRequest req,ServletResponse res)
	throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String roll=req.getParameter("roll");
		String name=req.getParameter("name");
		String branch=req.getParameter("branch");
		String address=req.getParameter("address");
		long phnumber=Long.parseLong(req.getParameter("phnumber"));
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			PreparedStatement ps=con.prepareStatement("insert into student16 values(?,?,?,?,?)");
			ps.setString(1,roll);
			ps.setString(2,name);
			ps.setString(3,branch);
			ps.setString(4,address);
			ps.setLong(5,phnumber);
			int k=ps.executeUpdate();
			if(k>0){
				pw.println("Student Added Successfully....");
			}
		} catch (Exception e) {
			
		}
	}

}
