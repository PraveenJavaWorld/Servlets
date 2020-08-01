package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class SecondServlet extends HttpServlet{
	@Override
	public void init() throws ServletException{
		
	}
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String code=req.getParameter("code");
		String name=req.getParameter("name");
		float totalBill=Float.parseFloat(req.getParameter("totalBill"));
		float fBill=totalBill-(0.24f*totalBill);
		res.sendRedirect("http://localhost:8082/TestApp1/dis?totalBill="+totalBill+"&fBill="+fBill+"&code="+code+"&name="+name);
	}

}
