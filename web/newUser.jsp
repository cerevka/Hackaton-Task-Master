<%-- 
    Document   : newUser
    Created on : 31.3.2012, 0:56:44
    Author     : adam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="my" %>

<my:layout title="Add new user">
   <form action="/rest/user" method="POST">
First Name: <input type="text" name="first_name"/>

Last Name: <input type="text" name="last_name" />
Email: <input type="text" name="email" />
Comment: <input type="text" name="comment" />
<input type="submit" value="Odeslat" />
</form>
</my:layout>