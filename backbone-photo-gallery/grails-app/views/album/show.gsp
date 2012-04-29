<%@ page import="cebartling.backbone.photogallery.domain.Album" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'album.label', default: 'Album')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-album" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                            default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="show-album" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list album">

        <g:if test="${albumInstance?.name}">
            <li class="fieldcontain">
                <span id="name-label" class="property-label"><g:message code="album.name.label" default="Name"/></span>

                <span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${albumInstance}"
                                                                                        field="name"/></span>

            </li>
        </g:if>

        <g:if test="${albumInstance?.dateCreated}">
            <li class="fieldcontain">
                <span id="dateCreated-label" class="property-label"><g:message code="album.dateCreated.label"
                                                                               default="Date Created"/></span>

                <span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate
                        date="${albumInstance?.dateCreated}"/></span>

            </li>
        </g:if>

        <g:if test="${albumInstance?.profile}">
            <li class="fieldcontain">
                <span id="profile-label" class="property-label"><g:message code="album.profile.label"
                                                                           default="Profile"/></span>

                <span class="property-value" aria-labelledby="profile-label"><g:link controller="profile" action="show"
                                                                                     id="${albumInstance?.profile?.id}">${albumInstance?.profile?.encodeAsHTML()}</g:link></span>

            </li>
        </g:if>

        <g:if test="${albumInstance?.albums}">
            <li class="fieldcontain">
                <span id="albums-label" class="property-label"><g:message code="album.albums.label"
                                                                          default="Albums"/></span>

                <g:each in="${albumInstance.albums}" var="a">
                    <span class="property-value" aria-labelledby="albums-label"><g:link controller="album" action="show"
                                                                                        id="${a.id}">${a?.encodeAsHTML()}</g:link></span>
                </g:each>

            </li>
        </g:if>

    </ol>
    <g:form>
        <fieldset class="buttons">
            <g:hiddenField name="id" value="${albumInstance?.id}"/>
            <g:link class="edit" action="edit" id="${albumInstance?.id}"><g:message code="default.button.edit.label"
                                                                                    default="Edit"/></g:link>
            <g:actionSubmit class="delete" action="delete"
                            value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
