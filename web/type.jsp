
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="my" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<my:layout title="Type">
   <p>
       <fmt:message key="type.name" />: ${it.type.name}
   </p>
</my:layout>