
<%@page import="java.util.List"%>
<%@page import="com.srtu.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success Page</title>
</head>
<body>
<%List <Student>list=(List) request.getAttribute("data");
for(Student Stu:list) {%>
Id=<%=Stu.getId() %>
<br>
Name=<%=Stu.getName() %>
<br>
Address=<%=Stu.getAddress() %>
<br>
<%} %>





</body>
</html>