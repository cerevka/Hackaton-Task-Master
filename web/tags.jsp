<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="my" %>

<fmt:message key="login.role" var="title" />

<my:layout title="${title}" active="tags">
    
    <h1><fmt:message key="heading.tags" /></h1>
    
    <my:tags tags="${it.tags}" />
    
</my:layout>