<html>
<head>
    <meta name="layout" content="main"/>
    <r:require modules="profile"/>

    <!-- Templates -->
    <script type="text/template" id="tpl-profile-list-item">
        <a href='#profiles/{{ id }}'>{{ fullname }}</a>
    </script>

    <script type="text/template" id="tpl-profile-details">

        <form class="form-horizontal">
            <fieldset>
                <legend>Profile Details</legend>

                <div class="control-group">
                    <label class="control-label" for="id">ID:</label>

                    <div class="controls">
                        <input type="text" class="input-small" id="id" name="id" disabled="disabled" value="{{ id }}">

                        %{--<p class="help-block">Supporting help text</p>--}%
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label" for="fullname">Full name:</label>

                    <div class="controls">
                        <input type="text" class="input-medium" id="fullname" name="fullname" value="{{ fullname }}">

                        %{--<p class="help-block">Supporting help text</p>--}%
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label" for="id">Username:</label>

                    <div class="controls">
                        <input type="text" class="input-medium" id="username" name="username" value="{{ username }}">

                        %{--<p class="help-block">Supporting help text</p>--}%
                    </div>
                </div>
            </fieldset>
        </form>

    </script>

</head>

<body>

<h1>Profiles</h1>

<div class="row-fluid">
    <div id="profilesContainer" class="well span3"></div>

    <div id="profileDetailsContainer" class="well span7"></div>
</div>

</body>
</html>
