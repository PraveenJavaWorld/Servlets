package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
public class AddProductServlet extends GenericServlet{
	@Override
	public void init() throws ServletException{	
	
	}
	
	@Override
	public void service(ServletRequest req,ServletResponse res)
	throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String code=req.getParameter("code");
		String name=req.getParameter("name");
		float price=Float.parseFloat(req.getParameter("price"));
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			PreparedStatement ps=con.prepareStatement("insert into Products16 values(?,?,?,?)");
			ps.setString(1,code);
			ps.setString(2,name);
			ps.setFloat(3,price);
			ps.setInt(4,quantity);
			int k=ps.executeUpdate();
			if(k>0)
			{
				pw.println("Product Added Successfully....");
			}
		}
		catch (Exception e) {
			
		}
		
	}

}
