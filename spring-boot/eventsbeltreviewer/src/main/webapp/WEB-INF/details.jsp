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
<title><c:out value="${event.name}"/></title>
</head>
<body>

<!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
    <div class="container">
      <a class="navbar-brand" href="#">Welcome ${user.firstName} to Event ${event.name} Planner </a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="/events/">Dashboard
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
	<div id="top">
		
		
	</div>
	<div id="container">
		<div id="lftpnl">
		
			<div class="card border-info mb-3" style="max-width: 50rem;">
			  <div class="card-header">Host: ${event.user.firstName}  ${event.user.lastName}</div>
			  <div class="card-body text-info">
			    <h5 class="card-title">Date: <fmt:formatDate pattern ="MMMM dd, yyyy" value ="${event.date}"/></h5>
			    <p class="card-text">
			    	
			    	<c:choose>
			    		<c:when test="${like == true}">
			    		<a href="${event.id}/unlike">Unlike</a>
			    		</c:when>
			    		<c:otherwise>
			    			<a href="${event.id}/like">Like</a>
			    		</c:otherwise>
			    	</c:choose>
                            
            
				    
					<p>Location: <c:out value="${event.location}"/>, <c:out value="${event.state}"/></p>
					<p>Total attendees <c:out value="${event.joinedUsers.size() + 1}"/></p>
					<p>Total likes: ${totall}</p>
					<table class="table table-striped table-bordered table-hover">
						<thead>
			  				<tr>
			    				<th scope="col">Name</th>
							    <th scope="col">Location</th>
			  				</tr>
						</thead>
						<tbody>
		  					<c:forEach items="${attendees}" var="attendee">
				  				<tr>
							    	<td><c:out value="${attendee.firstName}"/> <c:out value="${attendee.lastName}"/></td>
							    	<td><c:out value="${attendee.location}"/></td>
								<tr>
							</c:forEach>
						</tbody>
					</table>
			    </p>
			  </div>
			</div>						
		</div>
		
		
		<div id="rghtpnl">
			<div id="commentbox">
			<%-- ${event.messages} --%>
                <c:forEach items="${event.messages}" var="msg">
                    <p>Message from ${msg.user.firstName}:  ${msg.message}</p>
                </c:forEach>
            </div>
                <form:form method="post" action="/events/addmsg/${event.id}" modelAttribute="messageObj">
                	<p>
                		<form:input  type="text" path="message"/>
					</p>
					<form:hidden path="user" value="${user.id}"/>
					<form:hidden path="event" value="${event.id}"/>
			   		<input class="btn btn-outline-info" type="submit" value="Submit">          
                </form:form>
               	<form:errors cssClass="red" path="message.*"/>
		</div>
	</div>
	
</body>
</html>