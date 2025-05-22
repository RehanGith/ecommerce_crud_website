package ecommerce;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/ProductServlet")
public class productServlet extends HttpServlet {
	
	public static final String URL = "jdbc:mysql://localhost:3306/CRUD";
	public static final String NAME = "root";
	public static final String PASS = "rehan1007mahi@sql";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String my_action = req.getParameter("action");
		
		if(my_action == null) my_action = "list";
			
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL, NAME, PASS);
			
			
			//for listing 
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery("select * from product");
			req.setAttribute("product", rs);
			req.getRequestDispatcher("productListing.jsp").forward(req, resp);
			rs.close();
			stat.close();
			con.close();
		
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
