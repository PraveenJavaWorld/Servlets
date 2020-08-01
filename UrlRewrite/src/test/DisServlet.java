package test;
import java.io.*;
import java.util.*;
import java.util.function.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class DisServlet extends HttpServlet{
	public ServletContext sc;
	public ArrayList<TrainBean> al;
	@Override
	public void init() throws ServletException{
		sc=this.getServletContext();
		al=(ArrayList<TrainBean>)sc.getAttribute("JcfReg");
	}
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String number=req.getParameter("number");
		Predicate<TrainBean> p1=(k)->k.getNumber().equals(number);
		al.forEach((z)->{
			if(p1.test(z)){
			pw.println("<br>Number:"+z.getNumber());
			pw.println("<br>Name:"+z.getName());
			pw.println("<br>FStation:"+z.getFstation());
			pw.println("<br>LStation:"+z.getLstation());
			pw.println("<br>Available:"+z.getAvailability());
			}
			});
	}

}
