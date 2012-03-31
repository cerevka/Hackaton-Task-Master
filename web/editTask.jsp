<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fmtt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<my:layout title="Edit task">
    <h1><fmt:message key="task.edit.task" /></h1>
    <c:if test="${not empty it.error}">
        <fmt:message key="task.error" />
    </c:if>

    <form action="/rest/task" method="post" id="editTask">
        <div class="left">
        <input type="hidden" name="id" value="${it.task.id}">
        <label><fmt:message key="task.title" />:</label>
        <input type="text" name="title" value="${it.task.title}"/>

        <label><fmt:message key="task.description" />:</label>
        <input type="text" name="description" value="${it.task.description}"/>

        <label><fmt:message key="task.deadline" />:</label>
        <fmtt:formatDate value="${it.task.deadline}" pattern="dd.MM.yyyy" var="date" />
        <input type="text" name="deadline" value="${date}"/>

        <label><fmt:message key="task.progress" />:</label>
        <input type="text" name="progress" value="${it.task.progress}"/>
        </div>
        <div>
        <label><fmt:message key="task.state" />:</label>
        <select name="state">
            <c:forEach items="${it.states}" var="state">
                <option value="${state.name}" <c:if test="${it.task.state.name == state.name}">selected="select"</c:if>>${state.name}</option>
            </c:forEach>
        </select>

        <label><fmt:message key="task.type" />:</label>
        <select name="type">
            <c:forEach items="${it.types}" var="type">
                <option value="${type.name}" <c:if test="${it.task.type.name == type.name}">selected="select"</c:if>>${type.name}</option>
            </c:forEach>
        </select>

        <label><fmt:message key="task.priority" />:</label>
        <select name="priority">
            <option value="LOW"><fmt:message key="task.priority.low" /></option>
            <option value="MEDIUM"><fmt:message key="task.priority.medium" /></option>
            <option value="HIGH"><fmt:message key="task.priority.high" /></option>
        </select>
        </div>
        <input type="submit" class="submit" value="<fmt:message key="task.submit.edit" />" />
    </form>
</my:layout>