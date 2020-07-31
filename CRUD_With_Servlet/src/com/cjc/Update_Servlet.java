package com.cjc;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/update")

public class Update_Servlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		String sid=req.getParameter("eid");
		Employee emp=new Employee();
	
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","root");
				)
			{
				String sql="select * from Employee where ID=?";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1, emp.getEmpid());
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					
					emp.setName(rs.getString(2));
					emp.setAddress(rs.getString(3));
					emp.setEmail(rs.getString(4));
					emp.setUsername(rs.getString(5));
					emp.setPassword(rs.getString(6));
				}
				req.setAttribute("data", emp);
				RequestDispatcher rd = req.getRequestDispatcher("Update.jsp");
				rd.forward(req, res);
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
	}

}
