<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>

<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<%
    UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();
%>

<%if (user != null) {%>
<a href="<%= userService.createLogoutURL(request.getRequestURI())%>" title="<fmt:message key="login.logout" />"></a>
<div>
    <strong><fmt:message key="login.username" />:&nbsp;</strong><%= user.getNickname() %>
</div>
<div>
    <strong><fmt:message key="login.email" />:&nbsp;</strong>
</div>
<div>
    <strong><fmt:message key="login.role" />:&nbsp;</strong>Majitel
</div>
<% } else {%>
    <a href="<%= userService.createLoginURL(request.getRequestURI())%>"></a>
<% }%>