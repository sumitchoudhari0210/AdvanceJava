package com.srtu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class New_list_add extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List <Student> list= new ArrayList();
		Student s= new Student ();
		s.setId("1");
		s.setName("Sumit");
		s.setAddress("Nagpur");
		req.setAttribute("data", s);
		
		Student s1= new Student ();
		s1.setId("1");
		s1.setName("Rahul");
		s1.setAddress("Pune");
		req.setAttribute("data", s);
		
		list.add(s1);
		list.add(s);
		
		req.setAttribute("data", list);
		
		RequestDispatcher rd= req.getRequestDispatcher("success.jsp");
		
	}

}
