<%-- 
    Document   : user
    Created on : 31.3.2012, 0:48:24
    Author     : adam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="my" %>


<my:layout title="User">

    <h1>${it.user.firstname} ${it.user.surname}</h1>


    <strong>Role:&nbsp;</strong>${it.user.role} <br>

    <strong>Email:&nbsp;</strong>${it.user.email} <br><br>

    <a href="/rest/user/edit/${it.user.id}">Editovat profil</a>
    <c:forEach items="${it.tasks}" var="task" >
        <div id="tasks">      
            <my:task task="${task}"></my:task>    
            </div>         
    </c:forEach>
</my:layout>