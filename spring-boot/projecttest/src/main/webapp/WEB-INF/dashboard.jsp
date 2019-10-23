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
<title>Events</title>
</head>
<body>

<!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
    <div class="container">
      <a class="navbar-brand" href="#">Welcome ${user.firstName} to Belt Test </a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="/ideas">Dashboard
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

		       
        <!-- <a href="/ideas/ordered/ASC">order asc</a> -->
        
			<table class="table table-striped table-bordered table-hover">
				<thead>
	  				<tr>
	    				<th scope="col">Event Name</th>					    
					    <th scope="col">Created by </th>
					    <th scope="col">Likes</th>
					    <th scope="col">Action/Status</th>
	  				</tr>
				</thead>
				<tbody>
					<c:forEach items="${ideas}" var="in">
	  				<tr>
	  					<td><a href="${in.id}"><c:out value="${in.name}"/></a></td>
	  					
					    <td><c:out value="${in.user.firstName}"/></td>
					    <td><c:out value="${in.getJoinedUsers().size()}"/></td>
                        
                            <c:set var="attending" value="${false}"/>
                            <c:forEach items="${in.getJoinedUsers()}" var="attendee">
                                <c:if test="${attendee == user}">
                                    <c:set var="attending" value="${true}"/>
                                </c:if>
                            </c:forEach>
                            <c:choose>
                                <c:when test="${attending == false}">
                                    <td><a href="${in.id}/join">Like</a></td>
                                </c:when>
                                <c:otherwise>
                                    <td> <a href="${in.id}/cancel">Unlike</a></td>
                                </c:otherwise>
                            </c:choose>
                        
	  				</tr>
	  				</c:forEach>
				</tbody>
			</table>
		
		<div id="lftpnl">
								 
		<div id="rghtpnl">
		<a href="/ideas/new"> Create new Idea </a>
		</div>
	</div>
</body>
</html>