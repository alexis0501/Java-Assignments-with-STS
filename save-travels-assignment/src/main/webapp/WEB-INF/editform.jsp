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
<title>Edit Travels</title>
</head>
<body>
	<h1>Edit a Travel</h1>
	<form:form action="/travels/${travel.id }/edit" method="post" modelAttribute="travel">
	<input type="hidden" name="_method" value="put"> 
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
	    <button>Edit</button>
	</form:form> 
	
	
	
</body>
</html>