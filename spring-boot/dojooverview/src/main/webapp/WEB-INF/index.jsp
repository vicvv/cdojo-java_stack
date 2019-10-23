<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Questions Dashboard</h1>
<table>
    <tr><th>Question</th><th>Tags</th></tr>
    <c:forEach var="q" items="${questions}">
        <tr>
        	<td><a href="/questions/${q.id}">${q.q}</a></td>
        	<td><c:forEach items="${q.tags}" var="tag">(${tag.t}) </c:forEach></td>
        </tr>
    </c:forEach>
</table>
<a href="/questions/new">New Question</a>