
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
		<div class="d-flex justify-content-between">
			<h1>Add a book to your shelf!</h1>
			<a class="btn btn-primary" style="height: 38px" href="/home">Back to shelves</a>
		</div>
			<form:form action="/books/new" method="post" modelAttribute="book">
			<form:hidden path="reader" value="${userId}" />
			<div class="form-group">
				<form:label path="title">Title:</form:label>
				<form:input path="title" class="form-control" />
				<form:errors path="title" class="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="author">Author:</form:label>
				<form:input path="author" class="form-control" />
				<form:errors path="author" class="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="myThoughts">MyThoughts:</form:label>
				<form:input path="myThoughts" class="form-control" />
				<form:errors path="myThoughts" class="text-danger" />
			</div>	
			<button class="btn btn-primary">submit</button>			
			</form:form>
	</div>
</body>
</html>