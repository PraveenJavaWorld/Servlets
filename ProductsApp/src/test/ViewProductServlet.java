package test;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.*;
public class ViewProductServlet extends GenericServlet{
	public Connection con;
	@Override
	public void init() throws ServletException{
		con=DBConnection.get();
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		RequestDispatcher rd=req.getRequestDispatcher("Link.html");
		rd.include(req, res);
		try {
			PreparedStatement ps=con.prepareStatement("select * from products16");
			ResultSet rs=ps.executeQuery();
			ArrayList<ProductBean>al=new ArrayList<ProductBean>();
			while(rs.next()){
				ProductBean pb=new ProductBean();
				pb.setCode(rs.getString(1));
				pb.setName(rs.getString(2));
				pb.setPrice(rs.getFloat(3));
				pb.setQuantity(rs.getInt(4));
				al.add(pb);
			}//end of loop
			req.setAttribute("jcfRef",al);
			RequestDispatcher rd1=req.getRequestDispatcher("dis");
			rd1.forward(req, res);
		} catch (Exception e) {
			
		}
	}
	

}
