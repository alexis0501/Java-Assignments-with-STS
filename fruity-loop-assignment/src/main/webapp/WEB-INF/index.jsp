<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Fruity Loops Assisgnment JSP</title>
    </head>
<body>
    <table class="table table-dark table-striped table-hover">
		<thead>
			<tr>
				<td>Name</td>
				<td>Price</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="fruit" items="${fruits}">
			<tr>
				<td><c:out value="${fruit.name}"/></td>
				<td><c:out value="${fruit.price}"/></td>
			</tr>	
		</c:forEach>
		</tbody>
	</table>
</body>
</html>
