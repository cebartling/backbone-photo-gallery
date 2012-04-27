<html>
<head>
    <meta name="layout" content="main"/>
    <r:require modules="profile"/>

    <!-- Templates -->
    <script type="text/template" id="tpl-profile-list-item">
        <a href='#profiles/{{ id }}'>{{ fullname }}</a>
    </script>

    <script type="text/template" id="tpl-profile-details">
        <div class="form-left-col">
            <label>Id:</label>
            <input type="text" id="profileId" name="id" value="{{ id }}" disabled/>
            <label>Full name:</label>
            <input type="text" id="fullname" name="fullname" value="{{ fullname }}" required/>
            <label>Username:</label>
            <input type="text" id="username" name="username" value="{{ username }}"/>
        </div>
    </script>

</head>

<body>

<div class="hero-unit">

    <h1>Photo Gallery</h1>

    <div>
        Example Grails application that demonstrates using Backbone.js for a rich client-side experience.
    </div>
</div>

<div id="profilesContainer">

</div>

<div id="profileDetailsContainer"></div>

%{--<g:if test="${command.hasErrors()}">--}%
%{--<div class="alert alert-error">--}%
%{--<a class="close" data-dismiss="alert">×</a>--}%
%{--<strong>Oh snap!</strong>--}%
%{--&nbsp;&nbsp;--}%
%{--There seems to be some things amiss in the form below.  Please correct the following issues and resubmit the form.--}%
%{--<br/>--}%
%{--<br/>--}%
%{--<g:renderErrors bean="${command}"/>--}%
%{--</div>--}%
%{--</g:if>--}%

</body>
</html>
