package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
public class AddProductServlet extends GenericServlet{
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
		String code=req.getParameter("code");
		String name=req.getParameter("name");
		float price=Float.parseFloat(req.getParameter("price"));
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		ProductBean pb=new ProductBean();
		pb.setCode(code);
		pb.setName(name);
		pb.setPrice(price);
		pb.setQuantity(quantity);
		try {
			PreparedStatement ps=con.prepareStatement("insert into Products16 values(?,?,?,?)");
			ps.setString(1,pb.getCode());
			ps.setString(2,pb.getName());
			ps.setFloat(3,pb.getPrice());
			ps.setInt(4,pb.getQuantity());
			int k=ps.executeUpdate();
			if(k>0){
				pw.println("<br>Product Added Successfully....");
			}
		} catch (Exception e) {
			
		}
	}
	

}
