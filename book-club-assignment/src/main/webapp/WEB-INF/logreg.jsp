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
   	<div class="container">
		<h1> Register here</h1>
		<form:form action="/register" method="post" modelAttribute="newUser">
		<div class="form-group">
			<form:label path="userName">User Name:</form:label>
			<form:input path="userName" class="form-control" />
			<form:errors path="userName" class="text-danger" />
		</div>	
		<div class="form-group">
			<form:label path="email">Email:</form:label>
			<form:input path="email" class="form-control" />
			<form:errors path="email" class="text-danger" />
		</div>	
		<div class="form-group">
			<label>Password:</label>
			<form:password path="password" class="form-control" />
			<form:errors path="password" class="text-danger" />
		</div>
		<div class="form-group">
			<label>Confirm Password:</label>
			<form:password path="confirm" class="form-control" />
			<form:errors path="confirm" class="text-danger" />
		</div>		
		<input type="submit" value="Register" class="btn btn-primary"/>
		</form:form>
		
		<h1> Login</h1>
		<form:form action="/login" method="post" modelAttribute="newLogin">

		<div class="form-group">
			<form:label path="email">Email:</form:label>
			<form:input path="email" class="form-control" />
			<form:errors path="email" class="text-danger" />
		</div>	
		<div class="form-group">
			<label>Password:</label>
			<form:password path="password" class="form-control" />
			<form:errors path="password" class="text-danger" />
		</div>
		<input type="submit" value="Login" class="btn btn-primary" />
		</form:form>
   </div>
</body>
</html>
