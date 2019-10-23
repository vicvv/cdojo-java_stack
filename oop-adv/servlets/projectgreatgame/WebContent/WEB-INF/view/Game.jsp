<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Great Game </title>
</head>
<body>

<h1>Welcome to the Great Number Game!</h1>
<p>I'm thinking of a number between 1 and 100.</p>

<p>Take a guess!</p>

<% String responseType = (String) session.getAttribute("responseType");

if(responseType == "correct"){ %>
	<div class="correct">
		<h3>CORRECT!</h3>
		<p>Play again?</p>
	</div>
<% } else if(responseType == "low"){%>
	
	<div class="low"><h3>Too Low</h3></div>
<% } else if(responseType == "high"){ %>
	<div class="high"><h3>Too High</h3></div>
<% } %>
<!-- form sends a post request to the root url so we can have only one servlet -->
<form action="/projectgreatgame/" method="post">
	<input type="number" name="guess"><br>
	<input type="submit" value="Guess">
</form>

</body>
</html>