<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="my" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<my:layout title="Users" active="users">
    <h1><fmt:message key="heading.users" /></h1>
    <table>
        <thead>
        <th><fmt:message key="users.name" /></th>
        <th><fmt:message key="users.surname" /></th>
        <th><fmt:message key="users.role" /></th>
    </thead>

    <tbody>

        <c:forEach items="${it.users}" var="user" >
            <tr> 
                <td> ${user.firstname}</td>
                <td><a href="/rest/user/${user.id}"> ${user.surname}</a></td>
                <td> ${user.role}</td>

            </tr>
        </c:forEach>

    </tbody>
</table>
</my:layout>