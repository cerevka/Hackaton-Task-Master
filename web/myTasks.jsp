<%-- 
    Document   : myTasks
    Created on : 31.3.2012, 10:04:21
    Author     : adam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<my:layout title="New Type">
   <a href="/rest/taskByUser/1"><fmt:message key="label.mytasks" /></a>
   <a href="/rest/taskByUser/2"><fmt:message key="label.minetasks" /></a>
   <a href="/rest/taskByUser/3"><fmt:message key="label.volunteer" /></a>
    <h1><fmt:message key="heading.myTasks" /></h1>

    <div id="tasks">
        <c:forEach items="${it.tasks}" var="task">
            <my:task task="${task}"></my:task>
        </c:forEach>
    </div>
</my:layout>
