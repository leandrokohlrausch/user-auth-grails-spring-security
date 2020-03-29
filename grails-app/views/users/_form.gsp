<div>
    <label>Username</label>
    <input name="username" required="required" value="${user.username}"/>
</div>

<div>
    <label>Name</label>
    <input name="name" required="required" value="${user.name}"/>
</div>

<div>
    <label>E-mail</label>
    <input type="email" name="email" required="required" value="${user.email}"/>
</div>

<div>
    <label>Password</label>
    <input type="password" name="password" required="required" value="${user.password}">
</div>

<div>
    <g:checkBox name="enabled" value="${user.enabled}"/>
    <label>Enabled</label>
</div>

<div>
    <g:checkBox name="accountExpired" value="${user.accountExpired}"/>
    <label>Account Expired</label>
</div>

<div>
    <g:checkBox name="accountLocked" value="${user.accountLocked}"/>
    <label>Account Locked</label>
</div>

<div>
    <g:checkBox name="passwordExpired" value="${user.passwordExpired}"/>
    <label>Password Expired</label>
</div>
<h1>User Roles</h1>
<g:set var="authorities" value="${user.getAuthorities()}"/>
<g:each in="${roles}" var="role">
    <g:set var="check" value="${authorities.find { it.id.equals(role.id) } ? "true" : "false"}"/>
    <div>
        <g:checkBox name="userRole" value="${role.id}" checked="${check}" />
        <label>${role.authority}</label>
    </div>
</g:each>
