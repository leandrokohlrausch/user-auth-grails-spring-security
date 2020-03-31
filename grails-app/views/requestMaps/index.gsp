<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title></title>
    <meta name="layout" content="main"/>
</head>
<body>
<g:link controller="users" action="index">Back</g:link>
<g:link controller="requestMaps" action="create">Create</g:link>
<table>
    <thead>
    <tr>
        <th>URL</th>
        <th>Config</th>
        <th>Method</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${requestMaps}" var="req">
        <tr>
            <td>${req.url}</td>
            <td>${req.configAttribute}</td>
            <td>${req.httpMethod}</td>
            <td><g:link controller="requestMaps" action="delete" params="${[id: req.id]}">Delete</g:link></td>
        </tr>
    </g:each>
    </tbody>
</table>
</body>
</html>