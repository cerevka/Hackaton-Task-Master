<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="my" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<my:layout title="Types">
    <table>
        <thead>
        <th>
            <fmt:message key="type.name" />
        </th>
    </thead>

    <tbody>

        <c:forEach items="${it.types}" var="type" >
            <tr>
                <td> ${type.name}</td>
            </tr>
        </c:forEach>

    </tbody>
</table>
</my:layout>