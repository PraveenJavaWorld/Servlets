package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
public class AddTrainServlet extends GenericServlet{
	@Override
	public void init() throws ServletException{
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		long number=Long.parseLong(req.getParameter("number"));
		String name=req.getParameter("name");
		String fstation=req.getParameter("fstation");
		String lstation=req.getParameter("lstation");
		String avail=req.getParameter("avail");
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			PreparedStatement ps=con.prepareStatement("insert into trains16 values(?,?,?,?,?)");
			ps.setLong(1,number);
			ps.setString(2,name);
			ps.setString(3,fstation);
			ps.setString(4,lstation);
			ps.setString(5,avail);
			int k=ps.executeUpdate();
			if(k>0){
				pw.println("Train Added Successfully....");
			}
		}
		catch (Exception e) {
			
		}
		
		
	}

}
