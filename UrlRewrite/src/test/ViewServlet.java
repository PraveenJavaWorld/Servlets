package test;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ViewServlet extends HttpServlet{
	public ServletContext sc;
	public ArrayList<TrainBean> al;
	public Connection con;
	@Override
	public void init() throws ServletException{
		sc=this.getServletContext();
		al=new ArrayList<TrainBean>();
		con=DBConnection.get();
	}
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		try {
			PreparedStatement ps=con.prepareStatement("select * from Trains16");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				TrainBean tb=new TrainBean();
				tb.setNumber(rs.getString(1));
				tb.setName(rs.getString(2));
				tb.setFstation(rs.getString(3));
				tb.setLstation(rs.getString(4));
				tb.setAvailability(rs.getString(5));
				al.add(tb);
				pw.println("<br>");
				pw.println("<a href='dis?number="+rs.getString(1)+"'>"+rs.getString(1)+"</a>");
				pw.println("&nbsp"+rs.getString(2));
			}//end of while
			sc.setAttribute("JcfReg", al);
		} catch (Exception e) {
			
		}
	}

}
