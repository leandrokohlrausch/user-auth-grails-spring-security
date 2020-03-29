<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="main"/>
</head>
<body>
    <h1>Custom Login Page</h1>
    <g:form controller="login" action="authenticate" method="POST">
        <label for="username">Username</label>
        <input id="username" name="username" value=""/>
        <label for="password">Password</label>
        <input type="password" id="password" name="password" value=""/>
        <div>
            <input id="remember-me" type="checkbox" name="remember-me">
            <label for="remember-me">Lembrar</label>
        </div>
        <g:submitButton name="login" value="Login" />
    </g:form>

    <g:link controller="users" action="create">Create User</g:link>
</body>