package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet(value="/log",initParams={@WebInitParam(name="cval", value="2000")})
public class WelcomeServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		ServletConfig sc=this.getServletConfig();
		String uname=req.getParameter("uname");
		String cval=sc.getInitParameter("cval");
		pw.println("Login Successfull....");
		pw.println("<br>WELCOME:"+uname);
		pw.println("<br>CVal:"+cval);
	}

}
