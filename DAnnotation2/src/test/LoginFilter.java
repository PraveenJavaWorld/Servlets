package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebFilter("/log")
public class LoginFilter implements Filter{
	public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)
	throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String uname=req.getParameter("uname");
		if(uname.equals("chvnspraveen1997")){
			chain.doFilter(req, res);
		}//end of if
		else{
			pw.println("Invalid Credentials");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
	}

}
