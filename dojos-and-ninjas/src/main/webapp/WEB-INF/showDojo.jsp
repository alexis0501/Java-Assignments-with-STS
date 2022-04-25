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
	<h1><c:out value="${ dojo.name }"/> Ninjas</h1>
	<table class="table">
		<thead>
		<tr>
			<td>First Name</td>
			<td>Last Name</td>
			<td>Age Name</td>
		</tr>
		<c:forEach var="ninja" items="${ dojo.ninjas }">
		<tr>
			<td><c:out value="${ ninja.firstName }"></c:out></td>
			<td><c:out value="${ ninja.lastName }"></c:out></td>
			<td><c:out value="${ ninja.age }"></c:out></td>
		</tr>
		</c:forEach>
		</thead>
	</table>
	</div>

</body>
</html>