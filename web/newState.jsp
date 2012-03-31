<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="my" %>

<my:layout title="New State">
    <h2><fmt:message key="state.title" /></h2>
    <form action="/rest/state" method="post">
            <label><fmt:message key="state.name" /></label>
            <input type="text" name="name" />
            <input type="submit" value="Odeslat" />
    </form>
</my:layout>