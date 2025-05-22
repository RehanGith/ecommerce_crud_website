package ecommerce;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
			
			if(my_action.equals("delete")) {
				int id = Integer.parseInt("id");
				PreparedStatement ps = con.prepareStatement("delete from product where std_id = ?");
				ps.setInt(1, id);
				ps.executeUpdate();
				ps.close();
				resp.sendRedirect("ProductServlet");
				con.close();
			}
			
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
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String product_id = req.getParameter("product_id");
	    String name = req.getParameter("name");
	    String description = req.getParameter("description");
	    String priceStr = req.getParameter("price");
	    String quantityStr = req.getParameter("quantity");

	    try {
	        // Validate numeric fields first
	        double price = Double.parseDouble(priceStr);
	        int quantity = Integer.parseInt(quantityStr);

	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection(URL, NAME, PASS);

	        if(product_id == null || product_id.isEmpty()) {
	            // INSERT (4 parameters)
	            PreparedStatement ps = con.prepareStatement(
	                "INSERT INTO product (name, description, price, quantity) VALUES (?, ?, ?, ?)");
	            ps.setString(1, name);
	            ps.setString(2, description);
	            ps.setDouble(3, price);
	            ps.setInt(4, quantity);
	            ps.executeUpdate();
	            ps.close();
	        } else {
	            // UPDATE (5 parameters)
	            int id = Integer.parseInt(product_id);
	            PreparedStatement ps = con.prepareStatement(
	                "UPDATE product SET name=?, description=?, price=?, quantity=? WHERE product_id=?");
	            ps.setString(1, name);
	            ps.setString(2, description);
	            ps.setDouble(3, price);
	            ps.setInt(4, quantity);
	            ps.setInt(5, id);
	            ps.executeUpdate();
	            ps.close();
	        }
	        
	        con.close();
	        resp.sendRedirect("ProductServlet");
	        
	    } catch(NumberFormatException e) {
	        // Handle invalid number format
	        resp.sendRedirect("error.jsp?message=Invalid number format");
	    } catch(Exception e) {
	        throw new ServletException(e);
	    }
	}
}
