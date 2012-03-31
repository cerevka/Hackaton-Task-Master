<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="my" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>


<fmt:message key="title.homepage" var="title" />

<my:layout title="${title}">

    <h1>Tasks</h1>

    <div id="tasks">
        <my:task task="${it.task}"></my:task>
    </div>

</my:layout>