
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
</my:layout>