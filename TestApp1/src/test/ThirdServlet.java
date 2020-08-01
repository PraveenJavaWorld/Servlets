package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ThirdServlet extends HttpServlet{
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
		float fBill=Float.parseFloat(req.getParameter("fBill"));
		pw.println("---Bill after Discount---");
		pw.println("<br>Code:"+code);
		pw.println("<br>Name:"+name);
		pw.println("<br>TotalBill:"+totalBill);
		pw.println("<br>FinalBill:"+fBill);
	}

}
