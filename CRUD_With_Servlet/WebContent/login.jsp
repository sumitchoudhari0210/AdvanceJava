<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
</head>
<body>
<%String msg= (String)request.getAttribute("msg"); 
if(msg!=null) 
{%>
<%=msg %>
<%} %>
<br>
<br>
<form action="Login" method="post">
Username: <input type="text" name="username"><br>
Password: &nbsp;<input type="password" name="password"><br>
<br><input type="submit" value="Submit"><br>
<br> Don't have account???
<br><a href="Register.jsp">Click here for Registration</a>
</form>

</body>
</html>