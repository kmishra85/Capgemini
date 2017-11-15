<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="success.jsp" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form action = "add.bk" modelAttribute = "book">

<table>
	<tr>
		<td>Train Id:</td>
		<td>
			<form:input path = "trainId"/>
			<form:errors path = "trainId"/>
		</td>
	</tr>
	
	<tr>
		<td>Train Name:</td>
		<td>
			<form:input path = "trainName"/>
			<form:errors path = "trainName"/>
		</td>
	</tr>
	
	<tr>
		<td>Source:</td>
		<td>
			<form:input path = "source"/>
			<form:errors path = "source"/>
		</td>
	</tr>
	
	<tr>
		<td>Destination:</td>
		<td>
			<form:input path = "destination"/>
			<form:errors path = "destination"/>
		</td>
	</tr>
	
	<tr>
		<td></td>
		<td>
			<input type = "submit" value = "submit"/>
		</td>
	</tr>
</table>
</form:form>



</body>
</html>