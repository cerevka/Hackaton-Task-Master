<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="task box" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<%@attribute name="task" required="true" type="hackaton.rest.TaskOverview" %>

<div class="full-progress">
    <span class="percent">${task.progress} %</span>  
    <div class="progress" style="width: ${task.progress}%">         
        <div class="task">
            <div class="content">
                <div class="state">${task.state}</div>
                <div class="head">
                    <h2><a href="${task.url}" title="${task.title}">${task.title}</a></h2>
                    <div class="type" />${task.type}</div>
            </div>
            <div class="description">
                ${task.description}
            </div>
            <div class="tags">
                <c:forEach items="${task.tags}" var="tag">
                    <div class="tag" style="background-color: ${tag.color}"><a href="#" title="${tag.text}">${tag.text}</a></div>
                </c:forEach>
            </div>
            
                <c:if test="${task.priority == 'LOW'}" ><div class="priority low"><fmt:message key="task.priority.low" /></div></c:if>
                <c:if test="${task.priority == 'MEDIUM'}" ><div class="priority medium"><fmt:message key="task.priority.medium" /></div></c:if>
                <c:if test="${task.priority == 'HEIGH'}" ><div class="priority height"><fmt:message key="task.priority.heigh" /></div></c:if>
            
        </div>
    </div>
</div>
</div>