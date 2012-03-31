<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="my" %>

<my:layout title="Stav">
    <h2><fmt:message key="state.title" /></h2>
    <form action="/rest/state" method="post">
        <p>
            <label><fmt:message key="state.name" /></label>
            <input type="text" name="name" />
        </p>
        <p>
            <input type="submit" value="state.submit" />
        </p>
    </form>
</my:layout>