<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="my" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>


<fmt:message key="title.homepage" var="title" />

<my:layout title="${title}" active="allTasks">

    <h1><fmt:message key="heading.allTasks" /></h1>

    <div id="tasks">
        <c:forEach items="${it.tasks}" var="task">
            <my:task task="${task}"></my:task>
        </c:forEach>
    </div>
    
    <div id="tags">
        
    </div>

</my:layout>