<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="my" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<fmt:message key="title.homepage" var="title" />

<my:layout title="${title}" active="home">
    
    <h1><fmt:message key="heading.welcome" /></h1>

</my:layout>