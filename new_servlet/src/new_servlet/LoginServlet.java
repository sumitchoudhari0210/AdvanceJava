package new_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	
@Override
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	System.out.println("welcome ");
	
	String uname=req.getParameter("t1");
//	String pass=req.getParameter("t2");
//	System.out.println(uname);
//	System.out.println(pass);
	
	PrintWriter out= res.getWriter();
	out.write("<html>");
	out.write("<head>");
	out.write("<body>");
	out.write("this is responce page" + uname);
	out.write("</body>");
	out.write("</head>");
	out.write("</html>");
	
	
	
}

}
