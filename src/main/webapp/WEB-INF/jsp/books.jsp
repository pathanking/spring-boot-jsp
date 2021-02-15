<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Books</title>
</head>
<body>
	<h1>Library of books</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>Author</th>
			<th>Name</th>
		</tr>
		<c:forEach var="book" items="${books}">
		<tr>
			<td>${book.id}</td>
			<td>${book.author}</td>
			<td>${book.name}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>