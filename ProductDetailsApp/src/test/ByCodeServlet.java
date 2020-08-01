package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
public class ByCodeServlet extends GenericServlet{
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
		String code=req.getParameter("code");
		RequestDispatcher rd=req.getRequestDispatcher("Link.html");
		rd.include(req, res);
		try {
			PreparedStatement ps=con.prepareStatement("select * from products16 where code=?");
			ps.setString(1,code);
			ResultSet rs=ps.executeQuery();
			pw.println("<br>&nbsp---Book Details---<br>");
			pw.println("<br>&nbspCODE&nbsp&nbsp&nbspNAME&nbsp&nbsp&nbspPRICE&nbsp&nbsp&nbspQUANTITY");
			if(rs.next()){
				pw.println("<br>&nbsp"+rs.getString(1)+"&nbsp&nbsp"+rs.getString(2)+"&nbsp&nbsp"+rs.getFloat(3)+"&nbsp&nbsp&nbsp&nbsp"+rs.getInt(4));
			}
			else{
				pw.println("<br>&nbsp---Invalid Book Code---");
				RequestDispatcher rd1=req.getRequestDispatcher("Product.html");
				rd1.include(req, res);
			}
		} catch (Exception e) {
			
		}
	}

}
