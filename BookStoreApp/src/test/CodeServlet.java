package test;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
public class CodeServlet extends GenericServlet{
	public Connection con;
	@Override
	public void init() throws ServletException{
		con=DBConnection.getCon();
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String code=req.getParameter("code");
		RequestDispatcher rd=req.getRequestDispatcher("link.html");
		rd.include(req, res);
		pw.println("<br>");
		try {
			PreparedStatement ps=con.prepareStatement("select * from books16 where code=?");
			ps.setString(1,code);
			ResultSet rs=ps.executeQuery();
			pw.println("<br>---Book Details---");
			if(rs.next()){
				pw.println("<br>"+rs.getString(1)+"&nbsp&nbsp"+rs.getString(2)+"&nbsp&nbsp"+rs.getString(3)+"&nbsp&nbsp"+rs.getFloat(4)+"&nbsp&nbsp"+rs.getInt(5));
			}//end of if
			else{
				pw.println("<br>---Invalid Book Code---");
				RequestDispatcher rd1= req.getRequestDispatcher("book.html");
				rd1.include(req, res);
			}
		} catch (Exception e) {
			
		}
		
	}

}
