<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>  
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="/css/main.css">
<title>Welcome</title>
</head>
<body>

<!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
    <div class="container">
      <a class="navbar-brand" href="#">Welcome to Belt Exam </a>
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
        </ul>
      </div>
    </div>
  </nav>
	<div id="container">
	
		<div id="leftpanel">
		
		<div class="card border-info mb-3" style="max-width: 50rem;">
		  <div class="card-header">Registration Form</div>
		  <div class="card-body text-info">
		    <h5 class="card-title"></h5>
		    <p class="card-text">
		    
      		<form:form method="post" action="/register" modelAttribute="user">
				<p class="myform">
					<form:label path="firstName">First Name:</form:label>
					<form:input cssClass="fields" type="text" path="firstName"/>
				</p>
				<p class="myform">
					<form:label path="lastName">Last Name:</form:label>
					<form:input cssClass="fields" type="text" path="lastName"/>
				</p>
				<p class="myform">
					<form:label path="email">Email:</form:label>
					<form:input cssClass="fields" type="email" path="email"/>
				</p>
				<p class="myform">
					<form:label path="location">Location:</form:label>
					<form:select cssClass="state" path="state">
						<c:forEach items="${state}" var="s">
							<form:option value="${s}"><c:out value="${s}"/></form:option>
						</c:forEach>
					</form:select>
					<form:input cssClass="smfields" type="text" path="location"/>
				</p>
				<p class="myform">
					<form:label path="password">Password:</form:label>
					<form:password cssClass="fields" path="password"/>
				</p>
				 <p class="myform">
					<form:label path="passwordConfirmation">Confirm Password:</form:label>
					<form:password cssClass="fields" path="passwordConfirmation"/>
				</p> 
				<input class="btn btn-outline-info" type="submit" value="Register"/>
			</form:form>
			<form:errors cssClass="red" path="user.*"/>
			</div>
   		 </p>
  		</div>
		</div>
			
			
		<div id="rightpanel">
		
		<div class="card border-info mb-3" style="max-width: 50rem;">
		<div class="card-header">Provide userid and password to login</div>
			<div class="card-body text-info">
		    <h5 class="card-title"></h5>
		    <p class="card-text">
	    		<form action="/login" method="post">
					<p>Email:<input class="fields" type="email" name="email"></p>
					<p>Password:<input class="fields" type="password" name="password"></p>
					<input class="btn btn-outline-info" type="submit" value="Login">
				</form>
    		</p>
  		</div>
		</div>
			
			
	</div>
</div>
</body>
</html>