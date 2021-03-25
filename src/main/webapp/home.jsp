<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<h2>Welcome ${currentUser.firstname} ${currentUser.surname}</h2>
	<h2>City</h2>
	<div>
		<a href="navigation?link=city&action=add">Add city</a>
	</div>
	<div>
		<a href="navigation?link=city&action=list">List of all cities</a>
	</div>
	<div>
		<a href="navigation?link=city&action=updateName">Update name of city</a>
	</div>
	<div>
		<a href="navigation?link=city&action=details">City details</a>
	</div>
	<div>
		<a href="navigation?link=city&action=delete">Delete city</a>
	</div>

</body>
</html>