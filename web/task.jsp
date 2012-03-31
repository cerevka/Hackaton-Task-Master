
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="my" %>

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
       <fmt:message key="task.dateCreated" />: ${it.task.dateCreated}
   </p>
   <p>
       <fmt:message key="task.deadline" />: ${it.task.deadline}
   </p>
   <p>
       <fmt:message key="task.state" />: ${it.task.state.name}
   </p>
   <p>
       <fmt:message key="task.type" />: ${it.task.type.name}
   </p>
</my:layout>