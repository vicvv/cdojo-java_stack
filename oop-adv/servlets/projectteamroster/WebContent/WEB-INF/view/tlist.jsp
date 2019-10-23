<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="models.team" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="/projectteamroster/addteam">Create New Team</a>
<table>
<tr>
<th>Team</th>
<th>Players</th>
<th>Action</th>
</tr>

<%for(int i = 0; i < team.getTeams().size();i++){ %>
<tr>
<td><%= team.getTeams().get(i).getTeamName() %></td>
<td><%= team.getTeams().get(i).getPlayers().size() %></td>
<td>
<a href="/projectteamroster/teams?id=<%=i%>">Details</a> 
<a href="/projectteamroster/teams?id=<%=i%>&delete=true">Delete</a>
</td>
</tr>
<%} %>

</table>
</body>
</html>