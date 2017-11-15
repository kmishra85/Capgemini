<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet"/>
</head>
<body>
<center>
<h1>Transaction Form</h1>
<br>
<hr/>
<br>
<form action="result.obj">
<table>
<tr>
	<td>Account ID:</td>
	<td>
	<select name="id" >
		<option value="Account ID" required>Account ID</option>
		<c:forEach items="${sessionScope.output}" var="list">
			<option value="${list}" required>${list}</option>
		</c:forEach>
	</select></td>
</tr>
	
	<tr>
		<td>Account Type:</td>
		<td><select name="type" required>
		<option value="savings">Savings Account</option>
		<option value="current">Current Account</option>
		</select></td>
	</tr>
	
<tr>
		<td>Amount to be withdrawn</td>
		<td><input type="text" name="amount" pattern="[0-9]{1,}" min='0' max='1000'   required ></td>
</tr>

<tr>
		<td><input type="submit" value="submit"></td>
</tr>
</table>
</form>
</center>
</body>
</html>