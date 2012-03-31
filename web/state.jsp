
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="my" %>

<my:layout title="State">
   <p>
       <fmt:message key="state.name" />: ${it.state.name}
   </p>
</my:layout>