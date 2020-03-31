<div>
    <label>URL</label>
    <input name="url" required="required" value="${requestMap.url}"/>
</div>

<div>
    <label>URL</label>
    <g:select name="httpMethod" from="${methods}" value="${requestMap.httpMethod}" noSelection="['':'Empty for all']"/>
</div>

<h1>Roles</h1>
<g:each in="${roles}" var="role">
    <div>
        <g:checkBox name="configAttribute" value="${role}" checked="${false}" />
        <label>${role}</label>
    </div>
</g:each>

