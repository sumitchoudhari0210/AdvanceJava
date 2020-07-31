package com.cjc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/delete")
public class Delete_Servlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		Employee emp=new Employee();
		String eid= req.getParameter("eid");
		System.out.println(eid);
		emp.setEmpid(Integer.parseInt(eid));
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","root");
				)
			{
				String sql="delete from Employee where ID=?";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1, emp.getEmpid());
				ps.execute();
				System.out.println("Record deleted Successfully");
				ps = con.prepareStatement("select * from Employee");
				ResultSet rs = ps.executeQuery();
				List<Employee> list = new ArrayList<Employee>();
				while(rs.next())
				{
					Employee emp1=new Employee();
					emp1.setEmpid(rs.getInt(1));
					emp1.setName(rs.getString(2));
					emp1.setAddress(rs.getString(3));
					emp1.setEmail(rs.getString(4));
					emp1.setUsername(rs.getString(5));
					emp1.setPassword(rs.getString(6));
					list.add(emp1);
				}
				req.setAttribute("data", list);
				RequestDispatcher rd = req.getRequestDispatcher("Success.jsp");
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
