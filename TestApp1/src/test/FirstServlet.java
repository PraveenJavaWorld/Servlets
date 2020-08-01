package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class FirstServlet extends HttpServlet{
	@Override
	public void init() throws ServletException{
		
	}
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String sub=req.getParameter("sub");
		if(sub.equals("GenerateBill")){
			String code=req.getParameter("code");
			String name=req.getParameter("name");
			float price=Float.parseFloat(req.getParameter("price"));
			int quantity=Integer.parseInt(req.getParameter("quantity"));
			float totalBill=price*quantity;
			if(totalBill>5000){
				res.sendRedirect("http://localhost:8082/TestApp2/discount?totalBill="+totalBill+"&code="+code+"&name="+name);
			}//end of if
			else{
				pw.println("---Bill without Discount---");
				pw.println("<br>Code:"+code);
				pw.println("<br>Name:"+name);
				pw.println("<br>TotalBill:"+totalBill);
				pw.println("<br>FinalBill:"+totalBill);
			}
		}
		else{
			RequestDispatcher rd=req.getRequestDispatcher("Product.html");
			rd.include(req, res);
		}
	}

}
