<html>
<head>
    <meta name="layout" content="main"/>
    <r:require modules="profile"/>

    <g:render template="profileListingTemplate"/>
    <g:render template="profileDetailTemplate"/>
    <g:render template="profileToolbarTemplate"/>

</head>

<body>

<h1>Profiles</h1>

<div class="row well-large">
    <div id="toolbarContainer"></div>
</div>

<div class="row well-large">
    <div class="row-fluid">
        <div id="profilesContainer" class="span3"></div>

        <div id="profileDetailsContainer" class="span6"></div>
    </div>
</div>

</body>
</html>
