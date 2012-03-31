<%@tag description="page layout" pageEncoding="UTF-8"%>
<%@attribute name="title" required="true" type="java.lang.String" %>

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
        <link rel="stylesheet" href="/css/blueprint/print.css" type="text/css" media="print">
        <!--[if lt IE 8]>
          <link rel="stylesheet" href="/css/blueprint/ie.css" type="text/css" media="screen, projection">
        <![endif]-->
        <!-- Blueprint STOP -->

        <link rel="stylesheet" href="/css/style.css" type="text/css" media="screen" />        
        <!-- Styles STOP -->

        <!-- Javascript START -->
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>        
        <!-- Javascript STOP -->

    </head>

    <body>
        <div id="container" class="container">

            <!-- Header START -->
            <div id="header">
                <div id="logo"><a href="/" title="<fmt:message key="logo.home" />"></a></div>
                <div id="login-box">
                    <a href="#" title="<fmt:message key="login.logout" />"></a>
                    <div>
                        <strong><fmt:message key="login.username" />:&nbsp;</strong>Karel Omáčka
                    </div>
                    <div>
                        <strong><fmt:message key="login.email" />:&nbsp;</strong>jan.omacka@taskmaster.com
                    </div>
                    <div>
                        <strong><fmt:message key="login.role" />:&nbsp;</strong>Majitel
                        
                    </div>
                    
                </div>
            </div>
        <!-- Header STOP -->

        <!-- Main menu START -->
        <div id="main-menu">
            <ul>
                <li><a href="#" title="Moje úkoly" class="icon" id="icon-my-tasks">Moje úkoly</a></li>
                <li><a href="#" title="Úkoly" class="icon" id="icon-all-tasks">Úkoly</a></li>
                <li><a href="#" title="Nový úkol" class="icon" id="icon-new-tasks">Nový úkol</a></li>
                <li><a href="#" title="Uživatelé" class="icon" id="icon-user">Uživatelé</a></li>
                <li><a href="#" title="Štítky" class="icon" id="icon-tag">Štítky</a></li>
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
