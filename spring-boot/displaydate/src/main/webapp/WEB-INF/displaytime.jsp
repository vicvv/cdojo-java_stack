<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Time</title>
</head>
<body>

<a href="/">Back</a><br>
		<span id="time"><fmt:formatDate value="${now}" pattern="h:mm a" /></span>
</body>
</html>