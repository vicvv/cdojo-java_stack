<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>What is your question?</h1>

<form method="post" action="/questions/new">
    Question: <textarea name="q" rows="4" cols="30"></textarea><br>
    Tags: <input type="text" name="tags" >
    <button>Submit</button>

</form>

</body>
</html>
