package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class WelcomeServlet extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String fname=req.getParameter("fname");
		pw.println("Dis from WelcomeServlet....");
		pw.println("<br>Welcome:"+fname);
	}

}
