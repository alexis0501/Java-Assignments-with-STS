<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>show</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="navbar">
		<h1>Expense details</h1>
		<a class="nav-link" href="/expenses">Go back</a>
	</div>
	<div class="container">
		<h3>Expense Name: <c:out value="${travel.expense }"></c:out></h3>
		<h3>Expense Description: <c:out value="${travel.description }"></c:out></h3>
		<h3>Vendor: <c:out value="${travel.vendor }"></c:out></h3>
		<h3>Amount spent: ${travel.amount }</h3>
	</div>
	
</body>
</html>