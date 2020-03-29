<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title></title>
    <meta name="layout" content="main"/>
</head>
<body>
<h1>You are LOGGED ${user.username}</h1>
<ul>
    <li>
        <g:link controller="logout">Logout</g:link>
    </li>
    <li>
        <g:link controller="users" action="list">See All Users</g:link>
    </li>
    <li>
        <g:link controller="users" action="show" params="${[id: user.id]}">See Current User</g:link>
    </li>
</ul>
</body>
</html>