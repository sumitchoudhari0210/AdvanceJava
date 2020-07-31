<%@page import="com.cjc.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Page</title>
</head>
<body>
<form action="update">
<table border="2">
<tr>
<th> ID </th>
<th> Name </th>
<th> Address </th>
<th> Email ID </th>
<th> Username </th>
<th> Password </th>
</tr>

<% Employee emp=(Employee)request.getAttribute("data"); %>
<tr>
<td><input type="hidden" name="eid" value=<%=emp.getEmpid() %>></td>
<td><input type="text" name="name" value=<%=emp.getName() %>></td>
<td><input type="text" name="address" value=<%=emp.getAddress() %>></td>
<td><input type="text" name="email" value=<%=emp.getEmail() %>></td>
<td><input type="text" name="username" value=<%=emp.getUsername() %>></td>
<td><input type="text" name="password" value=<%=emp.getPassword() %>></td>
<td><input type="submit" value="Submit"></td>
</tr>
</table>
</form>
</body>
</html>