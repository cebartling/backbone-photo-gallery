<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title><g:layoutTitle default="Photo Gallery"/></title>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->


    <link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon"/>
    <g:layoutHead/>
    <r:layoutResources/>
    <style>
    body {
        padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
    }
    </style>
</head>

<body>

<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="${request.contextPath}">Photo Gallery</a>

            <div class="nav-collapse">
                <ul class="nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Administration
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="${createLink(controller: 'profile', action: 'index')}">Profiles</a></li>
                        </ul>
                    </li>
                </ul>
            </div><!--/.nav-collapse -->
        %{--<div class="btn-group pull-right">--}%
        %{--<a class="btn btn-primary dropdown-toggle" data-toggle="dropdown" href="#">--}%
        %{--<i class="icon-user icon-white"></i> <sec:loggedInUserInfo field="username" />--}%
        %{--<span class="caret"></span>--}%
        %{--</a>--}%
        %{--<ul class="dropdown-menu">--}%
        %{--<li><a href="${createLink(controller: 'logout', action: 'index')}">Sign Out</a></li>--}%
        %{--</ul>--}%
        %{--</div>--}%
        </div>
    </div>
</div>

<div class="container">

    <g:layoutBody/>

</div> <!-- /container -->

<r:layoutResources/>
</body>
</html>



