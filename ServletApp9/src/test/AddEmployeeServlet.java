package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
public class AddEmployeeServlet extends GenericServlet{
	@Override
	public void init() throws ServletException{
		
	}
	@Override
	public void service(ServletRequest req,ServletResponse res)
	throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String desig=req.getParameter("desig");
		float bsal=Float.parseFloat(req.getParameter("bsal"));
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			PreparedStatement ps=con.prepareStatement("insert into Employees16 values(?,?,?,?)");
			ps.setString(1,id);
			ps.setString(2,name);
			ps.setString(3,desig);
			ps.setFloat(4,bsal);
			int k=ps.executeUpdate();
			if(k>0){
				pw.println("Employee Added Successfully....");
			}
		} catch (Exception e) {
			
		}
	}

}
