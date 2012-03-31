<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="my" %>

<my:layout title="New Type">
    <h2><fmt:message key="type.title" /></h2>
    <c:if test="${not empty it.error}">
        <fmt:message key="type.error" />
    </c:if>
    <form action="/rest/type" method="post">
            <label><fmt:message key="type.name" /></label>
            <input type="text" name="name" />
            <input type="submit" value="Odeslat" />
    </form>
</my:layout>