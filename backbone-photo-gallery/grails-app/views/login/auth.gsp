<html>
<head>
    <meta name='layout' content='unauthenticated_main'/>
    <title><g:message code="springSecurity.login.title"/></title>
    <r:require modules="core"/>

    <r:script>
        $(function () {
            $('#username').focus();
        });
    </r:script>

</head>

<body>

<div class="row">
    <g:if test='${flash.message}'>
        <div class='alert alert-error'>${flash.message}</div>
    </g:if>
</div>

<div class="span12">
    <form class="form-horizontal" action='${postUrl}' method='POST' autocomplete='off'>
        <fieldset>
            <legend>Log in</legend>

            <div class="control-group">
                <label class="control-label" for="username">
                    <g:message code="springSecurity.login.username.label"/>:
                </label>

                <div class="controls">
                    <input type='text' class='input-medium' name='j_username' id='username'/>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="username">
                    <g:message code="springSecurity.login.password.label"/>:
                </label>

                <div class="controls">
                    <input type='password' class='input-medium' name='j_password' id='password'/>
                </div>
            </div>

            <div class="control-group">

                <div class="controls">
                    <input type='checkbox' class='chk' name='${rememberMeParameter}' id='remember_me'
                           <g:if test='${hasCookie}'>checked='checked'</g:if>/>
                    <label for='remember_me'><g:message code="springSecurity.login.remember.me.label"/></label>
                </div>
            </div>

            <div class="control-group">

                <div class="controls">
                    <input type='submit' id="submit" value='${message(code: "springSecurity.login.button")}'
                           class="btn btn-primary btn-large"/>
                </div>
            </div>

        </fieldset>
    </form>
</div>

</body>
</html>
