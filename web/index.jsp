<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="my" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>


<fmt:message key="title.homepage" var="title" />

<my:layout title="${title}">

    <h1>Tasks</h1>

    <div id="tasks">
        <my:task progress="44" state="probíhá" title="Vyhrát hackatOn" type="obchodní" url="#"> 
            <p>
                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
            </p>
        </my:task>

    </div>

</my:layout>