<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="/css/main.css">
<title><c:out value="${idea.name}"/></title>
</head>


<body>

<!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
    <div class="container">
      <a class="navbar-brand" href="#">Welcome ${user.firstName} to Belt Exam </a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="/ideas/">Dashboard
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">About</a>
          </li> 
          <li class="nav-item">
            <a class="nav-link" href="/logout">Logout</a>
          </li>         
        </ul>
      </div>
    </div>
  </nav>
  
	<div id="container">
		
		<div id="lftpnl">
		
		<div class="card border-info mb-3" style="max-width: 50rem;">
		  <div class="card-header">Edit Form</div>
			  <div class="card-body text-info">
			    <h5 class="card-title">Edit  ${idea.name} </h5>
			    <p class="card-text">
						<form:form method="post" action="/ideas/${id}/edit" modelAttribute="idea">
							<input type="hidden" name="_method" value="put">
							<h4 class="myform">
								<form:label path="name">Name:</form:label>
								<form:input cssClass="fields" type="text" path="name"/>
							</h4>
							
							<form:hidden path="user" value="${user.id}"/>
							<input class="btn btn-outline-info" type="submit" value="Edit"/>
						</form:form>
						<form:errors cssClass="red" path="idea.*"/>
			    </p>
			  </div>
		</div>
			
		</div>
		<div id="rghtpnl">
		</div>
	</div>
</body>
</html>