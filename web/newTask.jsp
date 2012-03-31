<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<my:layout title="New Task" active="newTask">
    <h1><fmt:message key="task.pageTitle" /></h1>
    <c:if test="${not empty it.error}">
        <fmt:message key="task.error" />
    </c:if>

    <a href="/rest/state">Přidat stav</a>
    <a href="/rest/type">Přidat typ</a>
    
    <form action="/rest/task" method="post" id="newTask">
        <div class="left">
            <label><fmt:message key="task.title" />:</label>
            <input type="text" name="title" value="${it.task.title}"/>

            <label><fmt:message key="task.description" />:</label>
            <textarea name="description">${it.task.description}</textarea>

            <label><fmt:message key="task.deadline" />:</label>
            <input type="text" name="deadline" value="${it.task.deadline}" class="datepicker" />
        </div>
        <div>

            <label><fmt:message key="task.state" />:</label>
            <select name="state">
                <c:forEach items="${it.states}" var="state">
                    <option value="${state.name}">${state.name}</option>
                </c:forEach>
            </select>

            <label><fmt:message key="task.type" />:</label>
            <select name="type">
                <c:forEach items="${it.types}" var="type">
                    <option value="${type.name}">${type.name}</option>
                </c:forEach>
            </select>

            <label><fmt:message key="task.priority" />:</label>
            <select name="priority">
                <option value="LOW"><fmt:message key="task.priority.low" /></option>
                <option value="MEDIUM"><fmt:message key="task.priority.medium" /></option>
                <option value="HEIGH"><fmt:message key="task.priority.heigh" /></option>
            </select>
        </div>
        <input type="submit" value="<fmt:message key="task.submit.new" />" />
    </form>
</my:layout>