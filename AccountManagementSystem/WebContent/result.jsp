<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.cg.account.bean.*"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet"/>
</head>
<body>

<% AccountDetails b=(AccountDetails)session.getAttribute("bean"); %>

<h1>Transaction Details</h1>
<br>
<hr>
<br>
<center>
<table>
		<tr>
			<th>Transaction ID:</th>
			<td><%=b.getTransactionId() %></td>
		</tr>
		<tr>
			<th>Account ID:</th>
			<td><%=b.getAccountId() %></td>
		</tr>
		<tr>
			<th>Amount Withdrawn:</th>
			<td><%=b.getAmount() %></td>
		</tr>
		<tr>
			<th>Clear Balance:</th>
			<td><%=b.getBalance() %></td>
		</tr>
		
</table>
</center>
</body>
</html>