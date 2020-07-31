package com.cjc;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/Register")
public class Register_Servlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		Employee emp=new Employee();
		String empid=req.getParameter("empid");
		emp.setEmpid(Integer.parseInt(empid));
		emp.setName(req.getParameter("fname")+" "+req.getParameter("lname"));
		emp.setAddress(req.getParameter("addr"));
		emp.setEmail(req.getParameter("email"));
		emp.setUsername(req.getParameter("username"));
		emp.setPassword(req.getParameter("password"));
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","root");
				)
			{
				String sql="insert into Employee values(?,?,?,?,?,?)";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1, emp.getEmpid());
				ps.setString(2, emp.getName());
				ps.setString(3, emp.getAddress());
				ps.setString(4, emp.getEmail());
				ps.setString(5, emp.getUsername());
				ps.setString(6, emp.getPassword());
				
				ps.execute();
				
				res.sendRedirect("login.jsp");
				
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		//RequestDispatcher rd=req.getRequestDispatcher("Success.jsp");
		//rd.forward(req, res);
	}

}
