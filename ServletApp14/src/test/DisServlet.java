package test;
import java.io.*;
import javax.servlet.*;
public class DisServlet extends GenericServlet{
	public ServletContext sct;
	public ServletConfig sc;
	@Override
	public void init() throws ServletException{
		sct=getServletContext();
		sc=getServletConfig();
	}
	@Override
	public void service(ServletRequest req,ServletResponse res)
	throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String name=req.getParameter("name");
		int contextval=Integer.parseInt(sct.getInitParameter("ContextVal"));
		int configval=Integer.parseInt(sc.getInitParameter("ConfigVal"));
		pw.println("Welcome:"+name);
		pw.println("<br>ContextVal:"+contextval);
		pw.println("<br>ServerInfo:"+sct.getServerInfo());
		pw.println("<br>ConfigVal:"+configval);
		pw.println("<br>ServletName:"+sc.getServletName());
	}

}
