package newlogin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/regiser")
public class NewServlet_task extends HttpServlet{
static	List <Employee> list= new ArrayList<>();
int count=0;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String s= (String)req.getParameter("id");
		String name=(String) req.getParameter("name");
		String address=(String) req.getParameter("address");
		String username=(String) req.getParameter("username");
		String password=(String) req.getParameter("password");
		
		
		Employee e1= new Employee();
		
		e1.setId(s);
		e1.setAddress(address);
		e1.setName(name);
		e1.setUsername(username);
		e1.setPassword(password);
		
		
		list.add(e1);
		count++;
		if(count==2)
		{
         req.setAttribute("Sumit", list);

		RequestDispatcher rd= req.getRequestDispatcher("success.jsp");
		rd.forward(req, res);
		}
		else {
			RequestDispatcher rd= req.getRequestDispatcher("regiser.jsp");
			rd.forward(req, res);
		}
	}

}
