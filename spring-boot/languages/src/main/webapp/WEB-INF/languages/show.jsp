<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            <a class="nav-link" href="/languages">Dashboard
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">About</a>
          </li>
          
        </ul>
      </div>
    </div>
  </nav>

<div class="container">
    <div class="row">
      <div class="col-lg-12 text-center">
      
      <div class="card" style="width: 18rem;">
		  <div class="card-body">
		    <h5 class="card-title">Special title treatment</h5>
		    <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
		    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
	  
			<h1><c:out value="${language.name}"/></h1>
			<p>Creator: <c:out value="${language.creator}"/></p>
			<p>Version: <c:out value="${language.version}"/></p>
			
			<a href="/languages/${language.id}/edit">Edit language</a>
			<form action="/languages/delete/${language.id}" method="post">
			    <input type="hidden" name="_method" value="delete">
			    <input type="submit" class="btn btn-primary" value="Delete">
			</form>
		    
		   
		  </div>
	</div>


	
	</div>
	</div>
</div>

</body>
</html>