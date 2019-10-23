<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		<h1>New License</h1>
		<form:form action="/licenses/new" method="POST" modelAttribute="license">
			<form:label path="person">Person:
				<form:select path="person">
					<c:forEach items="${persons}" var="person">
        					<form:option value="${person.id}"><c:out value="${person.firstname} ${person.lastname}"/></form:option>
   					</c:forEach>
				</form:select>
			</form:label>
			<form:label path="state">State: 
				<form:input type="text" path="state"/>
			</form:label>
			<form:label path="expirationDate">Expiration Date: 
				<form:errors path="expirationDate"/>
				<form:input type="text" path="expirationDate"/>
			</form:label>
			<input type="submit" value="Create">
		</form:form>
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
</html>