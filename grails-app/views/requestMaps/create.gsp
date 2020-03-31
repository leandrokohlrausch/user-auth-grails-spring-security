<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title></title>
    <meta name="layout" content="main"/>
</head>
<body>
<g:link controller="requestMaps" action="index">Back</g:link>
<g:form controller="requestMaps" action="save">
    <g:render template="form"/>
    <g:submitButton name="save" value="Create"/>
</g:form>
</body>
</html>