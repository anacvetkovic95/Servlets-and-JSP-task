<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<div>
		<p>${errorMessage}</p>
		<form name="form" method="post" action="login">
		
			<label for="username">Username:</label> 
			<input type="text" id="username" name="username" placeholder="Enter Username" /> 
			
			<label for="password">Password:</label> 
			<input type="password" id="password" name="password" placeholder="Enter Password" /> 
			
			<input type="submit" value="Login" name="Login" />
		</form>
	</div>
</body>
</html>
