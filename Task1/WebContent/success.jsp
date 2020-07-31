<%@page import="newlogin.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success Page</title>
</head>
<body>
<%Employee e1=(Employee)request.getAttribute("Sumit"); %>
Id=<%=e1.getId() %>
Name=<%=e1.getName() %>
Address=<%=e1.getAddress() %>
Username=<%=e1.getUsername() %>
Password=<%=e1.getPassword() %>





</body>
</html>