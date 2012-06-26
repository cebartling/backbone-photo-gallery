<html>
<head>
    <meta name="layout" content="main"/>

    <r:script disposition="head">
        var profileId = ${profile.id};
    </r:script>

    <r:require modules="profile"/>

    <g:render template="profileDetailTemplate"/>
    <g:render template="../album/albumTemplate"/>
    <g:render template="../album/albumListingTemplate"/>
    <g:render template="../album/uploadPhotosDialog"/>
    <g:render template="../photo/photoTemplate"/>

</head>

<body>

<div id="profileContent"></div>

<div id="albumListingContent"></div>

</body>
</html>
