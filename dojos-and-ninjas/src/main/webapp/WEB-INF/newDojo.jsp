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
</head>
<body>
   <div class="container">
	<h1>Create a Dojo</h1>
	<form:form action="/dojos" method="post" modelAttribute="dojo" class="form-control">
	    <p>
	        <form:label path="name">Name</form:label>
	        <form:errors path="name" class="text-danger"/>
	        <form:input path="name" class="form-control"/>
	    </p>
    	<input class="btn btn-primary" type="submit" value="Submit"/>
	</form:form>   
	</div>
</body>
</html>