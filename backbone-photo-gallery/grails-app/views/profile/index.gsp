<html>
<head>
    <meta name="layout" content="main"/>

    <r:script disposition="head">
        var profileId = ${profile.id};
    </r:script>

    <r:require modules="profile"/>

    <g:render template="profileDetailTemplate"/>

</head>

<body>

<div id="profileContent"></div>

</body>
</html>
