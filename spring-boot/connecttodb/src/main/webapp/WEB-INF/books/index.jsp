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


<h1>All Books</h1>
<table class="table table-dark">
    <thead>
        <tr>
            <th>Title</th>
            <th>Description</th>
            <th>Language</th>
            <th>Number of Pages</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.title}</td>
            <td>${book.description}</td>
            <td>${book.language}</td>
            <td>${book.numberOfPages}</td>
            <td>
            	<form action="/books/${book.id}" method="post">
    				<input type="hidden" name="_method" value="delete">
    				<input type="submit" value="Delete">
				</form>|
				<a href="/books/${book.id}">View</a>|
            	<a href="/books/${book.id}/edit">Edit Book</a>|
            </td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<a href="/books/new">New Book</a>

</body>
</html>