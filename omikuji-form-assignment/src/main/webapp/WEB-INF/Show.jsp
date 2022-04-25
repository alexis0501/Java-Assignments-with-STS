<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<h1>Here's your Omikuji!</h1>
		<div class="bg-info.bg-gradient">
			<h3>
			In <c:out value="${number}"/> years, you will live in <c:out value="${city}"/> with
			<c:out value="${person}"/> as your room mate, <c:out value="${hobby}"/> for a living. 
			The next time you see a <c:out value="${living}"/> you will have good luck. Also,
			<c:out value="${comment}."/>
			</h3>
		</div>
		<a href="/">Back</a>
	</div>
</body>
</html>