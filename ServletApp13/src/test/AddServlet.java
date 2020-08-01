package test;
import java.io.*;
import javax.servlet.*;
public class AddServlet extends GenericServlet{
	@Override
	public void init() throws ServletException{
		
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		int op1=Integer.parseInt(req.getParameter("op1"));
		int op2=Integer.parseInt(req.getParameter("op2"));
		int result=op1+op2;
		pw.println("---Dis from AddServlet---");
		pw.println("<br>Addition:"+result);
		RequestDispatcher rd=req.getRequestDispatcher("input.html");
		rd.include(req, res);
		
	}

}
