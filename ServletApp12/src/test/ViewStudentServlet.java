package test;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
public class ViewStudentServlet extends GenericServlet{
	public Connection con;
	@Override
	public void init() throws ServletException{
		con=DBConnection.get();
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String roll=req.getParameter("roll");
		try {
			PreparedStatement ps=con.prepareStatement("select * from student16 where rollnumber=?");
			ps.setString(1,roll);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				pw.println(rs.getString(1)+"&nbsp&nbsp"+rs.getString(2)+"&nbsp&nbsp"+rs.getString(3)+"&nbsp&nbsp"+rs.getString(4)+"&nbsp&nbsp"+rs.getLong(5));
			}
			else{
				pw.println("Invalid Student RollNumber....");
			}
		} catch (Exception e) {
			
		}
		
	}
	

}
