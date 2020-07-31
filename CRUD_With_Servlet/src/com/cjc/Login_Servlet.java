package com.cjc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/Login")
public class Login_Servlet  extends HttpServlet{
	
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
		{
			String uname=req.getParameter("username");
			String pass=req.getParameter("password");
			Employee emp=new Employee();
			List<Employee> list=new ArrayList<>();
			boolean flag=false;
			boolean temp=false;
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","root");
					)
				{
					String sql="select * from Employee";
					PreparedStatement ps=con.prepareStatement(sql);
					java.sql.ResultSet rs=ps.executeQuery();
					while(rs.next())
					{
						if(uname.equals(rs.getString(5)) && pass.equals(rs.getString(6)))
						{
							emp.setEmpid(rs.getInt(1));
							emp.setName(rs.getString(2));
							emp.setAddress(rs.getString(3));
							emp.setEmail(rs.getString(4));
							emp.setUsername(rs.getString(5));
							emp.setPassword(rs.getString(6));
							list.add(emp);
							flag=true;
							break;
						}
						if(uname.equals("admin") && pass.equals("admin"))
						{
							Employee emp1=new Employee();
							emp1.setEmpid(rs.getInt(1));
							emp1.setName(rs.getString(2));
							emp1.setAddress(rs.getString(3));
							emp1.setEmail(rs.getString(4));
							emp1.setUsername(rs.getString(5));
							emp1.setPassword(rs.getString(6));
							list.add(emp1);
							temp=true;
						}
					}
					if(flag==true)
					{
						req.setAttribute("data", list);
						RequestDispatcher rd2=req.getRequestDispatcher("Success.jsp");
						rd2.forward(req, res);
					}
					else if(temp==true)
					{
						req.setAttribute("data", list);
						RequestDispatcher rd2=req.getRequestDispatcher("Success.jsp");
						rd2.forward(req, res);
					}
					else
					{
						req.setAttribute("msg", "Invalid Username/Password...!!!");
						RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
						rd.forward(req, res);
					}
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

