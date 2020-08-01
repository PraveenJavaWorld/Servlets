package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
public class DeleteTrainServlet extends GenericServlet{
	public Connection con;
	@Override
	public void init() throws ServletException{
		con=DBConnection.get();
	}
	@Override
	public void service(ServletRequest req,ServletResponse res)
	throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		long number=Long.parseLong(req.getParameter("number"));
		RequestDispatcher rd=req.getRequestDispatcher("Link.html");
		rd.include(req, res);
		pw.println("<br>");
		try {
			PreparedStatement ps=con.prepareStatement("delete from trains16 where trainnumber=?");
			ps.setLong(1,number);
			int k=ps.executeUpdate();
			if(k>0){
				pw.println("<br>TrainNumber&nbsp:"+number+"&nbsp&nbspis Successfully Deleted....");
			}
			else{
				pw.println("<br>TrainNumber:"+number+"is not found....");
			}
		} catch (Exception e) {
			
		}
	}

}
