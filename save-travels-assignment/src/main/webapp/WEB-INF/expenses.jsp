<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Travels</title>
</head>
<body>
	<h1>Save Travels</h1>
	<table>
		<thead>
			<tr>
				<th>Expenses</th>
				<th>Vendor</th>
				<th>Amount</th>
				<th colspan="2">Actions</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="travel" items= "${travels}">
				<tr>
					
					<td><a href="/expenses/${travel.id }"><c:out value="${travel.expense }"></c:out></a></td>
					<td><c:out value="${travel.vendor }"></c:out></td>
					<td>${travel.amount }</td>
					<td><a href="/travels/${travel.id}/edit">Edit</a></td>
					<td>
						<form action="/travels/${travel.id }" method="post">
						<input type="hidden" name="_method" value="delete">
						<button>Delete</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>	
	</table>
	<h1>New Book</h1>
	<form:form action="/process" method="post" modelAttribute="travel">
	    <p>
	        <form:label path="expense">Expense Name:</form:label>
	        <form:errors path="expense"/>
	        <form:input path="expense"/>
	    </p>
	    <p>
	        <form:label path="vendor">Vendor:</form:label>
	        <form:errors path="vendor"/>
	        <form:input path="vendor"/>
	    </p>
	    <p>
	        <form:label path="amount">Amount:</form:label>
	        <form:errors path="amount"/>     
			<form:input path="amount"/>
	    </p>
	   	<p>
	        <form:label path="description">Description:</form:label>
	        <form:errors path="description"/>
	        <form:textarea path="description"/>
	    </p>    
	    <input type="submit" value="Submit"/>
	</form:form> 
	
	
	
</body>
</html>