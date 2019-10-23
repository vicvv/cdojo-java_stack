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
      <a class="navbar-brand" href="#">Welcome ${user.firstName} to Event Planner </a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="">Dashboard
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

		
		<c:if test="${instate.size() == 0}"><h5>No events available in your area...</h5></c:if>
        <c:if test="${instate.size() > 0}"> <p>Events at your location:</p>
        
        <a href="${Collections.sort(instate)}">Sort Asc</a>  <a href="${Collections.sort(instate)}">Sort Desc</a> 
        <a href="/events/ordered/ASC">order asc</a>
        
			<table class="table table-striped table-bordered table-hover">
				<thead>
	  				<tr>
	    				<th scope="col">Name</th>
					    <th scope="col">Date</th>
					    <th scope="col">Location</th>
					    <th scope="col">Host</th>
					    <th scope="col">Action/Status</th>
	  				</tr>
				</thead>
				<tbody>
					<c:forEach items="${instate}" var="in">
	  				<tr>
	  					<td><a href="${in.id}"><c:out value="${in.name}"/></a></td>
	  					
					    <td><fmt:formatDate pattern ="MMMM dd, yyyy" value ="${in.date}"/></td>
					    
					    <td><c:out value="${in.location}"/></td>
					    <td><c:out value="${in.user.firstName}"/></td>
                        <c:choose>
                        <c:when test="${in.user == user}">
                            <td>Already Joined | <a href="${in.id}/edit">Edit</a> | <a href="${in.id}/delete">Delete</a></td>
                        </c:when>
                        <c:otherwise>
                            <c:set var="attending" value="${false}"/>
                            <c:forEach items="${in.getJoinedUsers()}" var="attendee">
                                <c:if test="${attendee == user}">
                                    <c:set var="attending" value="${true}"/>
                                </c:if>
                            </c:forEach>
                            <c:choose>
                                <c:when test="${attending == false}">
                                    <td><a href="${in.id}/join">Join</a></td>
                                </c:when>
                                <c:otherwise>
                                    <td> Already Joined | <a href="${in.id}/cancel">Cancel</a></td>
                                </c:otherwise>
                            </c:choose>
                        </c:otherwise>
                        </c:choose>  
	  				</tr>
	  				</c:forEach>
				</tbody>
			</table>
		</c:if>
		
		<c:if test="${outofstate.size() == 0}"><h5>No events available in other locations...</h5></c:if>
        <c:if test="${outofstate.size() > 0}"> <p>Events in other locations:</p>
		<table class="table table-striped table-bordered table-hover">
			<thead>
  				<tr>
    				<th scope="col">Name</th>
				    <th scope="col">Date</th>
				    <th scope="col">Location</th>
				    <th scope="col">State</th>
				    <th scope="col">Host</th>
				    <th scope="col">Action</th>
  				</tr>
			</thead>
			<tbody>
				<c:forEach items="${outofstate}" var="out">
  				<tr>
  					<td><a href="${out.id}"><c:out value="${out.name}"/></a></td>
				    <td><fmt:formatDate pattern ="MMMM dd, yyyy" value ="${out.date}"/></td>
				    <td><c:out value="${out.location}"/></td>
				    <td><c:out value="${out.state}"/></td>
				    <td><c:out value="${out.user.firstName}"/></td>
					<c:choose>
                        <c:when test="${out.user == user}">
                            <td>Already Joined | <a href="${out.id}/edit">Edit</a> | <a href="${out.id}/delete">Delete</a></td>
                        </c:when>
                        <c:otherwise>
                            <c:set var="attending" value="${false}"/>
                            <c:forEach items="${out.getJoinedUsers()}" var="goer">
                                <c:if test="${goer == user}">
                                    <c:set var="attending" value="${true}"/>
                                </c:if>
                            </c:forEach>
                            <c:choose>
                                <c:when test="${attending == false}">
                                    <td><a href="${out.id}/join">Join</a></td>
                                </c:when>
                                <c:otherwise>
                                    <td>Already Joined | <a href="${out.id}/cancel">Cancel</a></td>
                                </c:otherwise>
                            </c:choose>
                        </c:otherwise>
                    </c:choose>
  				</tr>
  				</c:forEach>
			</tbody>
		</table>
		</c:if>
		<div id="lftpnl">
		
		
		<div class="card border-info mb-3" style="max-width: 50rem;">
		  <div class="card-header">Create new event</div>
		  <div class="card-body text-info">
		    <h5 class="card-title"></h5>
		    <p class="card-text">
		    	<form:form method="post" action="/events/addevent/" modelAttribute="newevent">
				<h4 class="myform">
					<form:label path="name">Event Name:</form:label>
					<form:input cssClass="fields" type="text" path="name"/>
				</h4>
				<h4 class="myform">
					<form:label path="date">Event Date:</form:label>
					<form:input cssClass="fields" type="text" path="date"/>
				</h4>
				<h4 class="myform">
					<form:label path="location">Event Location:</form:label>
					
					<form:select cssClass="state" path="state" >
						<c:forEach items="${states}" var="state">
							<form:option value="${state}"><c:out value="${state}"/></form:option>
						</c:forEach>
					</form:select>
					<form:input cssClass="smfields" type="text" path="location"/>
				</h4>
				<form:hidden path="user" value="${user.id}"/>
				<input class="btn btn-outline-info" type="submit" value="Create"/>
			</form:form>
			<form:errors cssClass="red" path="newevent.*"/>
		    
		    </p>
		  </div>
		</div>					
		</div> 
						 
		<div id="rghtpnl">
		</div>
	</div>
</body>
</html>