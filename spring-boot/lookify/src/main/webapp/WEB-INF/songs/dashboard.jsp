<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
            <a class="nav-link" href="/songs/new">Add New</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/songs/top">Top Songs</a>
          </li>
          
          <form class="form-inline my-2 my-lg-0" action="/dashboard/search" method="POST">
     	 	<input class="form-control mr-sm-2" type="search" name="artist" placeholder="Search Artist" aria-label="Search">
     	 	<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    	</form>
    	
    	
        </ul>
      </div>
    </div>
  </nav>
  
  <!-- Page Content -->
  <div class="container">
    <div class="row">
      <div class="col-lg-12 text-center">
      <h1>Song list</h1>
        <table class="table table-dark">
		    <thead>
		        <tr>
		            <th>Title</th>
		            <th>Rating</th>
		            <th>Actions</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${songs}" var="song">
		        <tr>
		            <td><a href="/songs/${song.id}">${song.title}</td>
		            <td>${song.rating}</td>
		            <td>
		            	<a href="/songs/delete/${song.id}">Delete</a>|
						
		            	<a href="/songs/${song.id}/edit">Edit Song</a>|
		            </td>
		        </tr>
		        </c:forEach>
		    </tbody>
		</table>
        
      </div>
    </div>
  </div>
</body>
</html>