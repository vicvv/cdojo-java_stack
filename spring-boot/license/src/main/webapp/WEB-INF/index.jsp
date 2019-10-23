<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Licenses</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	<body>
	<div class="container">
		<h1>Licenses</h1>
		<a href="/persons/new">Add Person</a> | <a href="/licenses/new">Add License</a>
		<table class="table table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th>Name</th>
				<th>ID</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${persons}" var="person">
    			<tr>    
   				<td><a href="/persons/${person.id}"><c:out value="${person.firstname} ${person.lastname} ${person.license.state}"/></a></td>
    				<td><c:out value="${person.id}"/></td>
    			</tr>
			</c:forEach>
		</tbody>
		</table>
		<% if(request.getAttribute("errors") != null){ %>
		<fieldset>
		<legend>Errors</legend>
		<c:forEach items="${errors}" var="error">
			<p><c:out value="${error.getDefaultMessage()}"/></p>
		</c:forEach>
		</fieldset>
		<% } %>
	</div>
	</body>
</html>