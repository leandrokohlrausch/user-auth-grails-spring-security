<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title></title>
    <meta name="layout" content="main"/>
</head>
<body>
<g:link controller="users" action="index">Back</g:link>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Username</th>
        <th>Email</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${users}" var="user">
        <tr>
            <td>${user.name}</td>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td><g:link controller="users" action="show" params="${[id: user.id]}">Show</g:link></td>
        </tr>
    </g:each>
    </tbody>
</table>
</body>
</html>