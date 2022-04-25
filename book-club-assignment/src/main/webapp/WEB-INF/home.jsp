<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   <div class="container mt-5">
   <div class="d-flex justify-content-between">
   		<h1>Welcome, <c:out value="${ username }"/></h1>
		<a class="btn btn-info" style="height: 38px" href="/books/new">Create a book</a> 
		<a class="btn btn-danger" style="height: 38px" href="/logout">Logout</a>
	</div>
		<h3 class="text-secondary">Books from everyone's shelves</h3>
   		<table class="table">
   			<thead>
   				<tr>
   					<th>ID</th>
   					<th>Title</th>
   					<th>Author</th>
   					<th>Posted By</th>
   					<th colspan="2">Actions</th>
   				</tr>
   			</thead>
   				<tbody>
   					<c:forEach var="book" items="${books}">
   						<tr>
   							<td>${book.id }</td>
   							<td><a href="/books/${book.id }"> <c:out value="${book.title}"/> </a></td>
   							<td>${book.author }</td>
   							<td>${book.reader.userName}</td>
   							<c:choose>
   								<c:when test="${book.reader.id.equals(userId)}">
   									<td> <a href="/books/${book.id}/edit" class="btn btn-info">Edit</a></td>	
   									<td>
   										<form action="/books/${book.id}/delete" method="post">
   										<input type="hidden" name="_method" value="delete" />
   										<button class="btn btn-danger">Delete</button>
   										</form>
   									</td>  									
   								</c:when>
   								<c:otherwise>
   									<td></td>
   									<td></td>
   								</c:otherwise>
   							</c:choose>
   							

   						</tr>
   					</c:forEach>
   				</tbody>
   		</table> 
   </div>
</body>
</html>