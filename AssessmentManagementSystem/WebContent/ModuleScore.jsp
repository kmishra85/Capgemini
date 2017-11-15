<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.cg.assessment.bean.*"
    %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet">
</head>

<body>
<center>

<br>
<h1>Marks And Grade Obtained</h1>
<br>
<hr>
<br>
<% AssessmentDetails d=(AssessmentDetails)session.getAttribute("bean"); %>

<table>
<tr>
	<th>Trainee Id:</th>
	<td><%=d.getTraineeId() %></td>
	</td>
</tr>
<tr>
	<th>Module Name:</th>
	<td><%=d.getModuleName()%></td>>
</tr>
<tr>
	<th>Total:</th>
	<td><%= d.getTotalMarks()%></td>
</tr>
<tr>
	<th>Grade:</th>
	<td><%=d.getGrade() %></td>
</tr>
</table>
</center>
</body>
</html>