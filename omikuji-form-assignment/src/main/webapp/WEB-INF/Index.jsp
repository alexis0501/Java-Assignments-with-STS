<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji form</title>
 <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
    <div class="container">
        <h1>Send an Omikuji</h1>
        <form class="form form-control" action="/submit" method="POST">
            <label for="number">Pick a number from 5 to 25</label>
            <input type="number" class="form-control" name="number" id="number" min="5" max="25">
            <label for="city">Enter the name of a city:</label>
            <input type="text" class="form-control" name="city" id="city">
            <label for="person">Enter the name of a real person:</label>
            <input type="text" class="form-control" name="person" id="person">
            <label for="hobby">Enter professional endeavor or hobby:</label>
            <input type="text" class="form-control" name="hobby" id="hobby">
            <label for="living">Enter the name of a living thing:</label>
            <input type="text" class="form-control" name="living" id="living">
            <label for="comment">Say something nice to someone::</label>
            <input type="text" class="form-control" name="comment" id="comment">
            <p>Send and show a friend</p>
            <button class="btn btn-primary">Send</button>
        </form>
    </div>
</body>
</html>