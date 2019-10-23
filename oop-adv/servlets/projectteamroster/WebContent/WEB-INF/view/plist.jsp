<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="models.team" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Players</title>
</head>
<body>
<% team t = team.getTeams().get(Integer.parseInt(request.getParameter("id"))); %>
<p>test</p>
<p><%=t.getTeamName() %></p>
<p><a href="/projectteamroster/addnewplayer?id=<%=request.getParameter("id") %>">New Player</a></p>

<table>
<tr>
<th>First Name</th>
<th>Last Name</th>
<th>Age</th>
<th>Actions</th>
</tr>
<%for(int i = 0; i < t.getPlayers().size(); i++ ){ %>
<tr><td><%= t.getPlayers().get(i).getFname() %></td>
<td><%=t.getPlayers().get(i).getLname() %></td>
<td><%=t.getPlayers().get(i).getAge() %></td>
<td><a href="/projectteamroster/addnewplayer?team_id=<%= request.getParameter("id")%>&player_id=<%=i%>&delete=true">Delete</a></td>
</tr>
<%} %>
</table>

</body>
</html>