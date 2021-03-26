<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>City</title>
</head>
<body>
	<center><h2>City:</h2></center>
	<div align="center">
		<form action="${pageContext.request.contextPath}/city" method="post"> 
			<table> 
				<tr> 
					<th>Postal code:</th> 
					<td><input type="text" id="postalCode" name="postalCode" value="${requestScope.city.postalCode}"></td> 
				</tr> 
	
				<tr> 
					<th>Name:</th> 
					<td><input type="text" id="name" name="name" value="${requestScope.city.name}"></td> 
				</tr> 
			</table> 
			<input type="submit" name="action" value="add">
			<input type="submit" name="action" value="cancel">
		</form> 
	</div>
</body>
</html>