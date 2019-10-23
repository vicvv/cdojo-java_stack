<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<h1>${q.q}</h1>
<h3><c:forEach var="tag" items="${q.tags}"><span class="tag">(${tag.t})</span></c:forEach></h3>

<table>
    <tr><th>Answers</th></tr>
    ${q.answers}
    <c:forEach items="${q.answers}" var="ans">
        <tr><td>${ans.a}</td></tr>
    </c:forEach>
</table>

 <form:form modelAttribute="answerModel" method="post" action="/questions/${q.id}">
    <form:label path="a">
        Answer Question:<br>
        <form:errors path="a"/>
        <form:textarea path="a" name="a" rows="4" cols="30"/>
    </form:label>
    <button>Answer</button>
</form:form> 

<a href="/questions">Dashboard</a>