<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="my" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fmtt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<my:layout title="Comments">
    <h1>${it.task.title}</h1>
    <table>
        <thead>
        <th>
            <fmt:message key="comment.text" />
        </th>
        <th>
            <fmt:message key="comment.created" />
        </th>
        <th>
            <fmt:message key="comment.type" />
        </th>
        <th>
            <fmt:message key="comment.type" />
        </th>
    </thead>

    <tbody>

        <c:forEach items="${it.comments}" var="comment" >
            <tr>
                <td> ${comment.text}</td>
                <fmtt:formatDate value="${comment.created}" pattern="dd.MM.yyyy" var="date" />
                <td> ${date}</td>
                <td> ${comment.type}</td>
                <td> ${comment.ownership.id}</td>
            </tr> 
        </c:forEach>

    </tbody>
</table>
</my:layout>