import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import java.sql.*;

@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String genre = req.getParameter("genre");
        String published_dateString = req.getParameter("published_date");
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore","root","");
            
            String query = "INSERT into books(title,author,genre,published_date,price,quantity) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, title);
            ps.setString(2, author);
            ps.setString(3, genre);
            ps.setString(4, published_dateString);
            ps.setDouble(5, price);
            ps.setInt(6, quantity);

            int rowsAffected = ps.executeUpdate();
            
            if (rowsAffected > 0) {
                res.sendRedirect("booklist.html");
            } else {
                out.println("<div style=\"text-align: center; background-color: #ccffcc; border: 1px solid #00cc00; padding: 10px; border-radius: 5px;\">");
                out.println("<p style=\"font-size: 18px; color: #008000;\">Some error occurred! Please try again.</p>");
                out.println("<a href=\"addbook.html\" style=\"text-decoration: none; background-color: #008000; color: #ffffff; padding: 10px 20px; border-radius: 5px;\">Try Again</a>");
                out.println("</div>");
            }
            con.close();
        } catch(ClassNotFoundException | SQLException e) {
            out.println("<div style=\"text-align: center; background-color: #ffcccc; border: 1px solid #cc0000; padding: 10px; border-radius: 5px;\">");
            out.println("<p style=\"font-size: 18px; color: #cc0000;\">Error: " + e.getMessage() + "</p>");
            out.println("<a href=\"addbook.html\" style=\"text-decoration: none; background-color: #cc0000; color: #ffffff; padding: 10px 20px; border-radius: 5px;\">Try Again</a>");
            out.println("</div>");
        }
    }
}
