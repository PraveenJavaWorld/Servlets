package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class FirstServlet extends HttpServlet{
	public Connection con;
	@Override
	public void init() throws ServletException{
		con=DBConnection.get();
	}
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String uname=req.getParameter("uname");
		String pword=req.getParameter("pword");
		try {
			PreparedStatement ps=con.prepareStatement("select * from Userreg16 where username=? and password=?");
			ps.setString(1,uname);
			ps.setString(2,pword);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				HttpSession hs=req.getSession();
				hs.setAttribute("fname",rs.getString(3));
				pw.println("<form action='dis' method='post'>");
				pw.println("<input type='submit' value='Welcome'>");
				pw.println("</form>");
			}
			else{
				pw.println("Invalid Crendentials");
				RequestDispatcher rd=req.getRequestDispatcher("login.html");
				rd.include(req, res);
			}
		} catch (Exception e) {
			
		}
	}

}
