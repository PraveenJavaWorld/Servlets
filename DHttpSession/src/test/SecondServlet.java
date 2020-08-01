package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class SecondServlet extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		HttpSession hs=req.getSession();
		if(hs==null){
			pw.println("Please! Login first....");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
		else{
			String fname=(String)hs.getAttribute("fname");
			pw.println("Dis from SecondServlet....");
			pw.println("<br>Welcome:"+fname);
		}
	}

}
