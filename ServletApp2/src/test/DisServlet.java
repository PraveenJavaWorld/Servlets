package test;
import java.io.*;
import javax.servlet.*;
public class DisServlet extends GenericServlet{
	public void init() throws ServletException{
		
	}
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String name=req.getParameter("fullname");
		String mail=req.getParameter("mailid");
		long phno=Long.parseLong(req.getParameter("phno"));
		String password=req.getParameter("pword");
		pw.println("---Details---");
		pw.println("<br>FullName:"+name);
		pw.println("<br>MailID:"+mail);
		pw.println("<br>PhoneNumber:"+phno);
		pw.println("<br>Password:"+password);
	}

}
