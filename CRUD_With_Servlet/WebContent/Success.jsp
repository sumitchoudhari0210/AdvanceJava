<%@page import="java.util.List"%>
<%@page import="com.cjc.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function deleteRecord()
{
	alert("delete");
	document.MyForm.action="delete";
	document.MyForm.submit();
	//var id1 = document.getElementsByName("eid");
	//alert(id1.value);
}
function updateRecord()
{
	alert("update");
	document.MyForm.action="update";
	document.MyForm.submit();
}
</script>
<h1>Employee Information</h1>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Page</title>
</head>
<body>
<form name= "MyForm">
<table border="2">
<tr>
<th> ID </th>
<th> Name </th>
<th> Address </th>
<th> Email ID </th>
<th> Username </th>
<th> Password </th>
</tr>

<tbody>
<% List<Employee> elist= (List)request.getAttribute("data");
for(Employee emp: elist)
{%>
<tr>

<td><input type="radio" name="eid" value= <%=emp.getEmpid() %>> </td>
<td><%=emp.getName() %></td>
<td><%=emp.getAddress() %></td>
<td><%=emp.getEmail() %></td>
<td><%=emp.getUsername() %></td>
<td><%=emp.getPassword() %></td>
<td><input type= "button" value="DELETE" onclick="deleteRecord()"> &nbsp;&nbsp;&nbsp;&nbsp;</td>
<td><input type= "button" value="UPDATE" onclick="updateRecord()"> &nbsp;&nbsp;&nbsp;&nbsp;</td>
</tr>
<%} %>

</tbody>
</table>
</form>
<br>
<br>
<a href="Login.jsp">Logout</a> 
</body>
</html>