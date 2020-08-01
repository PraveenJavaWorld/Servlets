package test;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
public class ViewServlet extends GenericServlet{
	public Connection con;
	@Override
	public void init() throws ServletException{
		con=DBConnection.getCon();
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		RequestDispatcher rd=req.getRequestDispatcher("link.html");
		rd.include(req, res);
		pw.println("<br>");
		try {
			PreparedStatement ps=con.prepareStatement("select * from Books16");
			ResultSet rs=ps.executeQuery();
			pw.println("<br>---Book Details---");
			while(rs.next()){
				pw.println("<br>"+rs.getString(1)+"&nbsp&nbsp"+rs.getString(2)+"&nbsp&nbsp"+rs.getString(3)+"&nbsp&nbsp"+rs.getFloat(4)+"&nbsp&nbsp"+rs.getInt(5));
			}
		} catch (Exception e) {
			
		}
		
	}

}
