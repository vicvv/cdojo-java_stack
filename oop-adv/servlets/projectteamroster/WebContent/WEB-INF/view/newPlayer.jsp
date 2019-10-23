<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Player</title>
</head>

<body>

<p>Create New player</p>
<form method="post" action="/projectteamroster/teams?id=<%= request.getParameter("id") %>">
<p>First Name: <input type="text" name="first_name"></p>
<p>Last Name: <input type = "text" name = "last_name"></p>
<p>Age: <input type="number" name="age"></p>
<button>Add</button>


</body>
</html>