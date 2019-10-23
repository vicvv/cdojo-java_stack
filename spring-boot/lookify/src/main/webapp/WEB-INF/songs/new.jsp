<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
    <div class="container">
      <a class="navbar-brand" href="#">Start Bootstrap</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="/dashboard">Dashboard
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/">Add New</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/">Top Songs</a>
          </li>
          
          <form class="form-inline my-2 my-lg-0">
     	 	<input class="form-control mr-sm-2" type="search" name="artist" placeholder="Search Artist" aria-label="Search">
     	 	<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    	 </form> 
          
        </ul>
      </div>
    </div>
  </nav>
  
  
  <div class="card border-info mb-3" style="max-width: 80rem;">
  <div class="card-header">Header</div>
  <div class="card-body text-info">
    <h5 class="card-title">Add new Song</h5>
    
    
    <form:form action="/songs/new" method="POST" modelAttribute="song">
			<div class="form-group">
				<form:label for="title" path="title">Title: 
				<form:input type="text" path="title" class="form-control" id="title"/>
				</form:label>
			</div>
			<div class="form-group">
				<form:label path="artist">Artist: 
				<form:input type="text" path="artist" class="form-control" id="artist"/>
				</form:label>
			</div>
			<div class="form-group">
				<form:label path="rating">Rating (1-10): 
				<form:input type="number" path="rating" min="1" max="10" class="form-control" id="rating"/>
				</form:label>
			</div>
			
				<input type="submit" value="Add Song" class="btn btn-primary">
				
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
</div>

</body>
</html>