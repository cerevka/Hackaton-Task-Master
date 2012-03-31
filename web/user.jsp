<%-- 
    Document   : user
    Created on : 31.3.2012, 0:48:24
    Author     : adam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="my" %>


<my:layout title="User">
   <p>
       Jmeno: ${it.user.firstname}
       
   </p>
   <p>
        Prijmeni: ${it.user.surname}
   </p>
    <p>
        Role: ${it.user.role}
   </p>
    <p>
        Email: ${it.user.email}
   </p>
   <a href="/rest/user/edit/${it.user.id}">Editovat profil</a>
   <c:forEach items="${it.tasks}" var="task" >
     <div id="tasks">      
    <my:task task="${task}"></my:task>    
       </div>         
   </c:forEach>
</my:layout>