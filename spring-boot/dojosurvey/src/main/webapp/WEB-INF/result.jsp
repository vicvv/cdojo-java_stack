<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
    <div class="row">
      <div class="col-lg-12 text-left">
        <h1 class="mt-5">Dojo Survey Result</h1>
        <p class="lead">Lets see....</p>
        <ul class="list-unstyled">
          <li>Name: ${name}</li>
          <li>Location: ${dojo}</li>
          <li>Favorite Language: ${lang}</li>
          <li>Comments: ${comment}</li>
        </ul>
      </div>
    </div>
  </div>
</body>
</html>