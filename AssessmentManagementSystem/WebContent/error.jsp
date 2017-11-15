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
<br><br>
<h2>Error Occurred!
<c:if test="${sessionScope.getIDException!= null}">
<%=session.getAttribute("getIDException") %>
</c:if>
<c:if test="${sessionScope.addException!= null}">
<%=session.getAttribute("addException") %>
</c:if>
</h2><hr>
</center>
</body>
</html>