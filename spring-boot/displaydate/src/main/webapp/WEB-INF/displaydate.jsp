<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Date</title>
</head>
<body>

<a href="/">Back</a><br>
<span id="date"><fmt:formatDate value="${now}" pattern="EEEE, 'the' d 'of' MMMM, yyyy"/></span>
	

</body>
</html>