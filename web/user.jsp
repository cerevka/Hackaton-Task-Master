<%-- 
    Document   : user
    Created on : 31.3.2012, 0:48:24
    Author     : adam
--%>

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
</my:layout>