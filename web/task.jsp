<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="my" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@taglib prefix="fmtt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<my:layout title="Task">
    <p>
        <fmt:message key="task.title" />: ${it.task.title}
    </p>
    <p>
        <fmt:message key="task.description" />: ${it.task.description}
    </p>
    <p>
        <fmt:message key="task.priority" />: ${it.task.priority}
    </p>
    <p>
        <fmt:message key="task.progress" />: ${it.task.progress}
    </p>
    <p>
        <fmtt:formatDate value="${it.task.dateCreated}" pattern="dd.MM.yyyy" var="date" />
        <fmt:message key="task.dateCreated" />: ${date}
    </p>
    <p>
        <fmtt:formatDate value="${it.task.deadline}" pattern="dd.MM.yyyy" var="date1" />
        <fmt:message key="task.deadline" />: ${date1}
    </p>
    <p>
        <fmt:message key="task.state" />: ${it.task.state.name}
    </p>
    <p>
        <fmt:message key="task.type" />: ${it.task.type.name}
    </p>
    
   
    <h1>${it.task.title}</h1>
   
   <p>
       ${it.task.description}
   </p>
   <p>
       <fmt:message key="task.priority" />: ${it.task.priority}
   </p>
   <p>
       <fmt:message key="task.progress" />: ${it.task.progress}
   </p>
   <p>
       <fmtt:formatDate value="${it.task.dateCreated}" pattern="dd.MM.yyyy" var="date" />
       <fmt:message key="task.dateCreated" />: ${date}
   </p>
   <p>
       <fmtt:formatDate value="${it.task.deadline}" pattern="dd.MM.yyyy" var="date1" />
       <fmt:message key="task.deadline" />: ${date1}
   </p>
   <p>
       <fmt:message key="task.state" />: ${it.task.state.name}
   </p>
   <p>
       <fmt:message key="task.type" />: ${it.task.type.name}
   </p>
   <p>
       <a href="/rest/task/edit/${it.task.id}"><fmt:message key="task.edit.task" /></a>
   </p>
   
       <form action="/rest/task/${it.task.id}/ownership" method="post">
        <input type="submit" title="Prevzit" name="submit" />
    </form>
    
    <form action="/rest/task/${it.task.id}/commet" method="post" >
        <div>Komentar:</div>
        <textarea id="commentText" name="text" rows="15" cols="150" ></textarea><br />
        <input type="submit" name="Submin" title="Submit" />
    </form>

    <table>
        <tbody>
            <c:forEach items="${it.comments}" var="comment" >
                <tr>
                    <td colspan="2">${comment.created}</td>
                    <td colspan="10">${comment.text}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</my:layout>