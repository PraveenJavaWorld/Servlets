package test;
import java.io.*;
import javax.servlet.*;
@SuppressWarnings("serial")
public class WelcomeServlet extends GenericServlet {
	public void init() throws ServletException {
		
	}
	public void service(ServletRequest req,ServletResponse res)
	throws ServletException,IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		pw.println("WELCOME TO SERVLET PROGRAMMING");
	}
	public void destroy() {
		
	}

}
