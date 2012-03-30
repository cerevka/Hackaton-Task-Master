<%@tag description="page layout" pageEncoding="UTF-8"%>
<%@attribute name="title" required="true" type="java.lang.String" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

        <title>${title} | Task Master</title>

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
        <script type="text/javascript" src="/javascript/jquery-1.7.2.min.js"></script>        
        <!-- Javascript STOP -->

</head>

<body>
    <div id="container" class="container">
        
        <!-- Header START -->
        <div id="header">
            <div id="logo"></div>
            
        </div>
        <!-- Header STOP -->
        
        <!-- Main menu START -->
        <div id="main-menu">
            
        </div>
        <!-- Main menu STOP -->
        
        <!-- Body START -->
        <div id="body">
            <jsp:doBody />
        </div>
        <!-- Body STOP  -->
        
        <!-- Footer START -->
        <div id="footer">
            
        </div>
        <!-- Footer STOP -->
    </div>
</body>
</html>
