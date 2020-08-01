package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class DisFilter implements Filter{
	public ServletContext sct;
	public FilterConfig fc;
	@Override
	public void init(FilterConfig fc) throws ServletException{
		sct=fc.getServletContext();
		this.fc=fc;
	}
	@Override
	public void doFilter(ServletRequest req,ServletResponse res,FilterChain ch)
	throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		int ContextVal=Integer.parseInt(sct.getInitParameter("ContextVal"));
		int ConfigVal=Integer.parseInt(fc.getInitParameter("ConfigVal"));
		String name=req.getParameter("name");
		pw.println("WELCOME:"+name);
		pw.println("<br>ServerInfo:"+sct.getServerInfo());
		pw.println("<br>ContextVal:"+ContextVal);
		pw.println("<br>FilterName:"+fc.getFilterName());
		pw.println("<br>ConfigVal:"+ConfigVal);
	}

}
