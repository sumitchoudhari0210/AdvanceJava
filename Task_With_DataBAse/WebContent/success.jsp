<%@page import="com.register.Register"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success Page</title>
</head>
<body>
<h1>hello</h1>
<%List <Register>list=(List) request.getAttribute("data");
for(Register r:list) {%>
Age=<%=r.getAge() %>
<br>
Name=<%=r.getName() %>
<br>
Address=<%=r.getMobileno() %>
<br>
<%} %>
<a href="index.html">Click here for Log Out</a>
</body>
</html>