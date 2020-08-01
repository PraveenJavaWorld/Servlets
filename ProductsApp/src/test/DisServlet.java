package test;
import java.io.*;
import java.util.*;
import javax.servlet.*;
public class DisServlet extends GenericServlet{
	@Override
	public void init() throws ServletException{
		
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		RequestDispatcher rd=req.getRequestDispatcher("Link.html");
		rd.include(req, res);
		pw.println("<br>---Products---");
		ArrayList<ProductBean> al=(ArrayList<ProductBean>)req.getAttribute("jcfRef");
		al.forEach((k)->
		{
			ProductBean pb=(ProductBean)k;
			pw.println("<br>"+pb.getCode()+"&nbsp&nbsp"+pb.getName()+"&nbsp&nbsp"+pb.getPrice()+"&nbsp&nbsp"+pb.getQuantity());
		});
	}
	

}
