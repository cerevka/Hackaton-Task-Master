<%-- 
    Document   : newUser
    Created on : 31.3.2012, 0:56:44
    Author     : adam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="my" %>

<my:layout title="Add new user">
    <script>
        $('form#newUser').live("submit",function(){
            if($('input#name').val()==""){
                alert("Jmeno nesmi byt prazdne.");
                return false;
            }
            if($('input#surname').val()==""){
                alert("Prijmeni nesmi byt prazdne.");
                return false;
            }
           var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
           var email = $('input#email').val();
           if(email==""){
                alert("Email nesmi byt prazdny.");
                return false;
           }
	    if( !emailReg.test( email) ) {
                alert("Nespravny format emailu.");
	        return false;
	    } else {
	        return true;
	    }
            
        });
    </script>

    <form id="newUser" action="/rest/user" method="POST">
        First Name: <input type="text" id="name" name="first_name"/>
        Last Name: <input type="text" id="surname" name="last_name" />
        Email: <input type="text" id="email" name="email" />
        Comment: <input type="text" id="comment" name="comment" />
        <input type="submit" value="Odeslat" />
    </form>
</my:layout>