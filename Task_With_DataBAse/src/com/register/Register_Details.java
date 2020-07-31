package com.register;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;

import Util.Hibernateutil;



@WebServlet(urlPatterns="/register")
public class Register_Details extends HttpServlet {
	
	@Override
	protected void service (HttpServletRequest req1, HttpServletResponse res1) throws ServletException, IOException {
		
		

		
		
		 Session session=Hibernateutil.getSessionFactory().openSession();
		
		
			Register re= new Register();
			
			re.setUsername(req1.getParameter("username"));
			 re.setName(req1.getParameter("name"));
			 re.setAddress(req1.getParameter("address"));
			 re.setAge(req1.getParameter("age"));
			 re.setPassword(req1.getParameter("password"));
			 re.setMobileno(req1.getParameter("mobileno"));
			 
			 session.save(re);
			 session.beginTransaction().commit();
			 
			 RequestDispatcher rd= req1.getRequestDispatcher("index.html");
				rd.forward(req1, res1);
		 
		 
	
	
		}
		 
	
		 
				
	}
	


