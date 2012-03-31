<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="my" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<my:layout title="Add Users to task">
    <h2>
        <fmt:message key="task.title" />: ${it.task.title}
    </h2>

    <form action="/rest/userToTask" method="post">
        <input type="hidden" name="id" value="${it.task.id}">
        <label><fmt:message key="menu.users" />:</label>
        <select name="user">
            <c:forEach items="${it.users}" var="user">
                <option value="${user.id}">${user.firstname}</option>
            </c:forEach>
        </select>
        <input type="submit" value="<fmt:message key="task.submit.adduser" />" />
    </form>
</my:layout>