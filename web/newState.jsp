<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<my:layout title="New State">
    <h1><fmt:message key="state.title" /></h1>
    <c:if test="${not empty it.error}">
        <fmt:message key="state.error" />
    </c:if>
    <form action="/rest/state" method="post" id="newState">
        <label><fmt:message key="state.name" /></label>
        <input type="text" name="name" />
        <input type="submit" value="<fmt:message key="state.submit.new" />" />
    </form>
</my:layout>