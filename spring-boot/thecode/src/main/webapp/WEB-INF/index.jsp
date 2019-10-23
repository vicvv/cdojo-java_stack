<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>The Code</title>
	</head>
	<body>
		<% if(session.getAttribute("error") != null){ %>
			<h3><%= session.getAttribute("error") %></h3>
		<% } %>
		<h3>What is the code?</h3>
		<form action="/" method="post">
			<input type="text" name="guess">
			<input type="submit" value="Try Code">
		</form>
	</body>
</html>