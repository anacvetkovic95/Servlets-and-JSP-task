<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Cities</title>
</head>
<body>
	<div align="center">
		<form action="${pageContext.request.contextPath}/city" method="post"> 
			<table border="1" cellpadding="5">
			    <caption><h2>List of cities</h2></caption>
			    <tr>
			        <th>Postal code</th>
			        <th>Name</th>
			        <th>Actions</th>
			    </tr>
			    <c:forEach var="element" items="${cityRepository.findAll()}" varStatus="loop">
			        <tr>
			            <td><c:out value="${element.postalCode}" /></td>
			            <td><c:out value="${element.name}" /></td>
			            <td>
			            	<a href="navigation?link=city&action=edit?postalCode<c:out value='${element.postalCode}' />">Edit</a>
                        	<a href="navigation?link=city&action=delete?postalCode<c:out value='${element.postalCode}' />">Delete</a>
			            </td>
			        </tr>
			    </c:forEach>
			</table>
		<a href="${pageContext.request.contextPath}/home.jsp">Back to home</a>
		</form>
	</div>	
</body>
</html>