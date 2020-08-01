package pack;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class TestServlet extends HttpServlet{
	
	@Override
	public void service(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		PrintWriter out=res.getWriter();
		res.setContentType("text/html");
		HttpSession hs=req.getSession();
		String submit=req.getParameter("submit");
		if(submit.equals("Add")){
			hs.setAttribute(req.getParameter("name"),req.getParameter("value"));
			out.println("Attribute Added....<br/>");
		}
		else if (submit.equals("Remove")) {
			hs.removeAttribute(req.getParameter("name"));
			out.println("Attribute Removed....<br/>");
		}
		hs.invalidate();
		RequestDispatcher rd=req.getRequestDispatcher("home.html");
		rd.include(req, res);
	}

}
