<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>id</th>
			<th>code</th>
			<th>name</th>
			<th>type</th>
			<th>Delete</th>
			<th>Update</th>
			
		</tr>
		
		<c:forEach items="${locations}" var="location">
		<tr>
		<td>${location.id}</td>
		<td>${location.code}</td>
		<td>${location.name}</td>
		<td>${location.type}</td>
		<td><a href="deleteLocation?id=${location.id}">Delete</a></td>
		<td><a href="showUpdate?id=${location.id}">Edit</a></td>
		</tr>
		</c:forEach>	
	</table>
	
	<a href="showCreate">Add Location</a>


</body>
</html>