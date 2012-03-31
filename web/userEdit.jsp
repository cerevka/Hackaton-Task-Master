<%-- 
    Document   : UserEdit
    Created on : 31.3.2012, 6:15:44
    Author     : adam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="my" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<my:layout title="Edit user">
    <script>
        $('form#editUser').live("submit",function(){
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

    
    <form id="editUser" action="/rest/user/${it.user.id}" method="POST">
        <label for="name"><fmt:message key="form.newUser.name" />:&nbsp;</label> <input type="text" id="name" name="first_name" value=${it.user.firstname} />
        <label for="surname"><fmt:message key="form.newUser.surname" />:&nbsp;</label> <input type="text" id="surname"  name="last_name" value=${it.user.surname} />
        <label for="email"><fmt:message key="form.newUser.email" />:&nbsp;</label> <input type="text" id="email" name="email" value=${it.user.email} />
         <label for="comment"><fmt:message key="form.newUser.comment" />:&nbsp;</label> <input type="text" id="comment" name ="comment" value=${it.user.comment}  />
       <input type="submit" value="<fmt:message key="form.newUser.send" />" />
    </form>
</my:layout>