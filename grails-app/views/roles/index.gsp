<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title></title>
    <meta name="layout" content="main"/>
</head>
<body>
<g:link controller="users" action="index">Back</g:link>
<g:link controller="roles" action="create">Create</g:link>
<table>
    <thead>
    <tr>
        <th>Authority/th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${roles}" var="role">
        <tr>
            <td>${role.authority}</td>
            <td><g:link controller="roles" action="delete" params="${[id: role.id]}">Delete</g:link></td>
        </tr>
    </g:each>
    </tbody>
</table>
</body>
</html>