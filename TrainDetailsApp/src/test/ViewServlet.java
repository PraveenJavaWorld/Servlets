package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
public class ViewServlet extends GenericServlet{
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
		RequestDispatcher rd=req.getRequestDispatcher("Link.html");
		rd.include(req, res);
		pw.println("<br>");
		try{
			PreparedStatement ps=con.prepareStatement("select * from trains16");
			ResultSet rs=ps.executeQuery();
			pw.println("---Trains List---");
			while(rs.next()){
				pw.println("<br>"+rs.getLong(1)+"&nbsp&nbsp"+rs.getString(2)+"&nbsp&nbsp"+rs.getString(3)+"&nbsp&nbsp"+rs.getString(4)+"&nbsp&nbsp"+rs.getString(5));
			}
		}
		catch (Exception e) {
			
		}
	}

}
