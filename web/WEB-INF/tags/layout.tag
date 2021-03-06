<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="page layout" pageEncoding="UTF-8"%>
<%@attribute name="title" required="true" type="java.lang.String" %>
<%@attribute name="active" required="false" type="java.lang.String" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

        <title>${title} | Task Master</title>
        <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />

        <!-- Styles START -->

        <!-- Blueprint START -->
        <link rel="stylesheet" href="/css/blueprint/screen.css" type="text/css" media="screen, projection">
        <link rel="stylesheet" href="/css/jquery.miniColors.css" type="text/css" media="screen, projection">
        <link rel="stylesheet" href="/css/blueprint/print.css" type="text/css" media="print">
        <!--[if lt IE 8]>
          <link rel="stylesheet" href="/css/blueprint/ie.css" type="text/css" media="screen, projection">
        <![endif]-->
        <!-- Blueprint STOP -->

        <link rel="stylesheet" href="/css/style.css" type="text/css" media="screen" />        
        <link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/themes/start/jquery-ui.css" type="text/css" />

        <!-- Styles STOP -->

        <!-- Javascript START -->
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
        <script type="text/javascript" src="/js/jquery.miniColors.js"></script>
        <!-- Javascript STOP -->
        
        <script>
            /*
	$(document).ready(function() {
		$(".datepicker").datepicker({ dateFormat: 'dd.mm.yy' });
	});*/
        
        $(function() {
		$(".datepicker").datepicker({ dateFormat: 'dd.mm.yy' });
	});
	</script>

    </head>

    <body>
        <div id="container" class="container">

            <!-- Header START -->
            <div id="header">
                <div id="logo"><a href="/" title="<fmt:message key="logo.home" />"></a></div>
                <div id="login-box">
                    <jsp:include page="login.jsp" />                    
                </div>
            </div>
        <!-- Header STOP -->

        <!-- Main menu START -->
        <div id="main-menu">
            <ul>
                <li><a href="/rest/taskByUser/1" title="<fmt:message key="menu.myTasks" />" class="icon<c:if test="${active == 'myTasks'}"> active</c:if>" id="icon-my-tasks"><fmt:message key="menu.myTasks" /></a></li>
                <li><a href="/rest/tasks" title="<fmt:message key="menu.allTasks" />" class="icon<c:if test="${active == 'allTasks'}"> active</c:if>" id="icon-all-tasks"><fmt:message key="menu.allTasks" /></a></li>
                <li><a href="/rest/task" title="<fmt:message key="menu.newTask" />" class="icon<c:if test="${active == 'newTask'}"> active</c:if>" id="icon-new-tasks"><fmt:message key="menu.newTask" /></a></li>
                <li><a href="/rest/users" title="<fmt:message key="menu.users" />" class="icon<c:if test="${active == 'users'}"> active</c:if>" id="icon-user"><fmt:message key="menu.users" /></a></li>
                <li><a href="/rest/tags" title="<fmt:message key="menu.tags" />" class="icon<c:if test="${active == 'tags'}"> active</c:if>" id="icon-tag"><fmt:message key="menu.tags" /></a></li>
            </ul>
        </div>
        <!-- Main menu STOP -->

        <!-- Body START -->
        <div id="body">
            <jsp:doBody />
        </div>
        <!-- Body STOP  -->

        <!-- Footer START -->
        <div id="footer">
            <div id="flags">
                <a href="#" id="cs" class="flag"></a>      
                <a href="#" id="en" class="flag"></a>
            </div>
            <div id="copyright">© Web Crushers, 2012</div>
        </div>
        <!-- Footer STOP -->
    </div>
</body>
</html>
