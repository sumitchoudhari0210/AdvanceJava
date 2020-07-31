package login_page;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		

		String uname=req.getParameter("username");
		String pass= req.getParameter("password");
		String adder= req.getParameter("address");
		String mno=req.getParameter("Mobile no");
		String name=req.getParameter("name");
		
			System.out.println(name);;
			System.out.println(adder);
			System.out.println(mno);
			System.out.println(uname);
			System.out.println(pass);
		
		RequestDispatcher rd= req.getRequestDispatcher("success.jsp");
		rd.forward(req, res);
	}
}
