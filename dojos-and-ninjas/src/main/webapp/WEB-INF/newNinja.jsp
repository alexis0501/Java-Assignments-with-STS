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
	<h1>Add Ninja</h1>
	<form:form action="/ninjas" method="post" modelAttribute="ninja" class="form-control">
	    <p>
	        <form:label path="dojo">Dojo</form:label>
	        <form:errors path="dojo" class="text-danger"/>
	        <form:select path="dojo" class="form-control">
	        <c:forEach var="newNinja" items="${dojos}">
	    		<form:option value="${ newNinja.id }"><c:out value="${ newNinja.name }"/></form:option>
	        </c:forEach>
	        </form:select>
	    </p>
	    <p>
	        <form:label path="firstName">First Name</form:label>
	        <form:errors path="firstName" class="text-danger"/>
	        <form:input path="firstName" class="form-control"/>
	    </p>
	    <p>
	        <form:label path="lastName">Last Name</form:label>
	        <form:errors path="lastName" class="text-danger"/>
	        <form:input path="lastName" class="form-control"/>
	    </p>
	    <p>
	        <form:label path="age">Age</form:label>
	        <form:errors path="age" class="text-danger"/>
	        <form:input type="number" path="age" class="form-control" min="0"/>
	    </p>
	    <button class="btn btn-primary">Create</button>
	</form:form>   
	</div>
</body>
</html>