<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   		<div class="container mt-5">
			<div class="d-flex justify-content-between align-items-center text-primary">
				<h1><i><c:out value="${book.title}"/></i></h1>
				<a class="btn btn-primary" href="/home">back to the shelves</a>
			</div>
			<div class="container mt-5">
				<h3>${book.reader.userName} read ${book.title} by ${book.author}</h3>
				<h3>Here are ${book.reader.userName} thoughts:</h3>
				<h4 class="mt-5 text-secondary">
				${book.myThoughts}
				</h4>
   					<c:choose>
   						<c:when test="${book.reader.id.equals(userId)}">
   							<td> <a href="/books/${book.id}/edit" class="btn btn-info">Edit</a></td>									
   						</c:when>
   					</c:choose>							
			</div>
		</div>
</body>
</html>