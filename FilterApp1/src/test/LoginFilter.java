package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class LoginFilter implements Filter{
	public Connection con;
	public ServletContext sct;
	@Override
	public void init(FilterConfig fc) throws ServletException{
		con=DBConnection.get();
		sct=fc.getServletContext();
	}
	@Override
	public void doFilter(ServletRequest req,ServletResponse res,FilterChain ch)
	throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String uname=req.getParameter("uname");
		String pword=req.getParameter("pword");
		try {
			PreparedStatement ps=con.prepareStatement("select * from userreg16 where username=? and password=?");
			ps.setString(1,uname);
			ps.setString(2,pword);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				sct.setAttribute("fname",rs.getString(3));
				ch.doFilter(req, res);
			}
			else{
				pw.println("Invalid Credentials....");
				RequestDispatcher rd=req.getRequestDispatcher("login.html");
				rd.include(req, res);
			}
		} catch (Exception e) {
			
		}
	}

}
