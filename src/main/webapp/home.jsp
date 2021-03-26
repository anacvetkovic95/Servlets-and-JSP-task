<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<h2>Welcome ${currentUser.name}</h2>
	<h2>City</h2>
	<div>
		<a href="navigation?link=city&action=add">Add city</a>
	</div>
	<div>
		<a href="navigation?link=city&action=list">List of all cities</a>
	</div>
	<div>
		<a href="navigation?link=city&action=update">Update city</a>
	</div>
	<div>
		<a href="navigation?link=city&action=details">City details</a>
	</div>
	<div>
		<a href="navigation?link=city&action=delete">Delete city</a>
	</div>
	
	<h2>Manufacturer</h2>
	<div>
		<a href="navigation?link=manufacturer&action=add">Add manufacturer</a>
	</div>
	<div>
		<a href="navigation?link=manufacturer&action=list">List of all manufacturers</a>
	</div>
	<div>
		<a href="navigation?link=manufacturer&action=updateName">Update manufacturer</a>
	</div>
	<div>
		<a href="navigation?link=manufacturer&action=details">Manufacturer details</a>
	</div>
	<div>
		<a href="navigation?link=manufacturer&action=delete">Delete manufacturer</a>
	</div>
	
	<h2>Product</h2>
	<div>
		<a href="navigation?link=product&action=add">Add product</a>
	</div>
	<div>
		<a href="navigation?link=product&action=list">List of all products</a>
	</div>
	<div>
		<a href="navigation?link=product&action=updateName">Update product</a>
	</div>
	<div>
		<a href="navigation?link=product&action=details">Product details</a>
	</div>
	<div>
		<a href="navigation?link=product&action=delete">Delete product</a>
	</div>

</body>
</html>