package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class LoginServlet extends HttpServlet{
	UserDAO ud;
	public void init() throws ServletException{
		ud=new UserDAO();
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		String uname=req.getParameter("uname");
		String pass=req.getParameter("pass");
		ud=new UserDAO();
		if(ud.validate(uname,pass)){
			
			//Start Session
			HttpSession hs=req.getSession();
			hs.setAttribute("UserName",uname);
			RequestDispatcher rd=req.getRequestDispatcher("home");
			rd.forward(req, res);
		}//end of it
		else{
			RequestDispatcher rd=req.getRequestDispatcher("Login.html");
			rd.forward(req, res);
		}
	}

}
