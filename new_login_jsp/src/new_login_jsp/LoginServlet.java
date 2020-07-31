package new_login_jsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("hello");
		
		String uname=req.getParameter("t1");
		String pass= req.getParameter("t2");
		
	if(uname.equals("Sumit")&&pass.equals("Sumit@123"))	
	{
		RequestDispatcher rd= req.getRequestDispatcher("Success.jsp");
		rd.forward(req, res);
	}
		
	
	else  
	{
		RequestDispatcher rd= req.getRequestDispatcher("wrong.html");
		rd.forward(req, res);
	}
		
	}

}
