<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="task box" pageEncoding="UTF-8"%>

<%@attribute name="task" required="true" type="hackaton.rest.TaskOverview" %>

<div class="full-progress">
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
                            <div class="tag"><a href="#" title="${tag.text}">${tag.text}</a></div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>