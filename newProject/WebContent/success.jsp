<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String name= request.getParameter("name"); %>
<%=name %>
<br>
<% String pass= request.getParameter("password"); %>
<%=pass %>
<br>
<% String address= request.getParameter("address"); %>
<%=address %>
<br>
<% String mobileno= request.getParameter("Mobile no"); %>
<%=mobileno %>
<br>
<% String uname= request.getParameter("username"); %>
<%=uname %>
<br>


</body>
</html>