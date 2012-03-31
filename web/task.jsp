<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="my" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@taglib prefix="fmtt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<my:layout title="Task">
    
    <script type="text/javascript">
        $('a.tag-ajax').live('click', function(){
            $.get($(this).attr('href'), function(data){
                location.reload();
            });            
            return false;
        });
    </script>

    <strong><fmt:message key="task.priority" />&nbsp;:</strong>${it.task.priority} <br>


    <strong><fmt:message key="task.progress" />&nbsp;:</strong>${it.task.progress} <br> 

    <fmtt:formatDate value="${it.task.dateCreated}" pattern="dd.MM.yyyy" var="date" /> 
    <strong><fmt:message key="task.dateCreated" />&nbsp;:</strong>${date} <br>

    <fmtt:formatDate value="${it.task.deadline}" pattern="dd.MM.yyyy" var="date1" />
    <strong><fmt:message key="task.deadline" />&nbsp;:</strong>${date1} <br>

    <strong><fmt:message key="task.state" />&nbsp;:</strong>${it.task.state.name} <br> 

    <strong><fmt:message key="task.type" />&nbsp;:</strong>${it.task.type.name} 


    <c:if test="${not empty tagsForOwnership}" >
        <div class="tags">
            <c:forEach items="${it.tagsForOwnership}" var="tag">
                <div class="tag" style="background-color: ${tag.color}"><a href="#" title="${tag.text}">${tag.text}</a></div>
            </c:forEach>
        </class>
    </c:if>

    <div class="tags" style="float: right">
        <c:forEach items="${it.allTags}" var="tag">
            <div class="tag" style="background-color: ${tag.color}"><a class="tag-ajax" href="/rest/task/${it.task.id}/tag/${tag.id}" title="${tag.text}">${tag.text}</a></div>
        </c:forEach>
    </div>

    <br><br>

    <a href="/rest/task/edit/${it.task.id}"><fmt:message key="task.edit.task" /></a><br>
    <a href="/rest/userToTask/${it.task.id}"><fmt:message key="task.submit.adduser" /></a>


    <c:if test="${it.noComments == false}" >
        <form action="/rest/task/${it.task.id}/commet" method="post" >
            <div>Komentar:</div>
            <textarea id="commentText" name="text" rows="15" cols="150" ></textarea><br />
            <input type="submit" name="Submin" title="Submit" />
        </form>
    </c:if>

    <table>
        <tbody>
            <c:forEach items="${it.comments}" var="comment" >
                <tr>
                    <td colspan="2"><fmtt:formatDate value="${comment.created}" pattern="hh:mm dd.MM.yyyy" /></td>
                    <td colspan="10"><c:if test="${comment.type == 'ACTION'}" ><i></c:if>${comment.text}<c:if test="${comment.type == 'ACTION'}" ></i></c:if></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>



</my:layout>