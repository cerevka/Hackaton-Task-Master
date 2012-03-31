<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="my" %>

<my:layout title="Users" active="users">
    <table>
        <thead>
        <th>
            jmeno
        </th>
        <th>
            prijmeni
        </th>
        <th>
            role
        </th>
    </thead>

    <tbody>

        <c:forEach items="${it.users}" var="user" >
           <tr> 
                <td> ${user.firstname}</td>
                <td><a href="/rest/user/${user.id}"> ${user.surname}</a></td>
                <td> ${user.role}</td>
                
            </tr>
        </c:forEach>

    </tbody>
</table>
</my:layout>