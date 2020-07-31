package com.register;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/login")
public class Login_Servlet extends HttpServlet {
	Collection<Register> l= new ArrayList();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

String username= req.getParameter("Username");
String password= req.getParameter("Password");


   try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginpage", "root", "root");
        String query = "SELECT * FROM register;";
       PreparedStatement ps= con.prepareStatement(query);
       
        
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
          

            if(username.equals(rs.getString(7))&& password.equals(rs.getString(6))){
               Register r1= new Register();
               r1.setPassword(rs.getString(5));
               r1.setUsername(rs.getString(6));
               r1.setName(rs.getString(4));
               r1.setAge(rs.getString(2));
               r1.setMobileno(rs.getString(3));
               l.add(r1);
             
               req.setAttribute("data",l);
               RequestDispatcher rd= req.getRequestDispatcher("success.jsp");
               rd.forward(req, res);
			
            }
       
          
        }
    }  catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }
  
}
}