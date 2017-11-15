<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<h1>Add Assessment Scores</h1>
<br>

<hr>
<br>
<h2>Enter the Details</h2>
<br>
<form action="ModuleScore.obj" method="get">
<table>
<tr>
	<th>Trainee id:</th>
	<td><select name="id" >
	<option value="default" >Trainee ID</option>
	<c:forEach items="${sessionScope.output}" var="list">
	<option value="${list}">${list}</option>
	</c:forEach>
	</select></td>
</tr>

<tr>
	<th>Module Name:</th>
	<td>
		<select name="module" >
		<option value="Module1" >Module1</option>
		<option value="Module2">Module2</option>
		<option value="Module3">Module3</option>
		<option value="Module4">Module4</option>
		<option value="Module5">Module5</option>
		</select>
	</td>
</tr>
<tr>
	<th>MPT:</th>
	<td><input type="text" name="mpt" required min="1" max="100" pattern="[0-9]{1,}"></td>
</tr>
<tr>
	<th>MTT:</th>
	<td><input type="text" name="mtt" required min="1" max="100" pattern="[0-9]{1,}"></td>
</tr>
<tr>
	<th>Assignment:</th>
	<td><input type="text" name="assignment" required min="1" max="100" pattern="[0-9]{1,}"></td>
</tr>
<tr>
	<td><input type="submit" value="submit"></td>
</tr>
</table>
</form>
</center>
</body>
</html>