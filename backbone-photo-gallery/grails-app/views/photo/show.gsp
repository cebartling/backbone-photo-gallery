<%@ page import="cebartling.backbone.photogallery.domain.Photo" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'photo.label', default: 'Photo')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-photo" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                            default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="show-photo" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list photo">

        <g:if test="${photoInstance?.name}">
            <li class="fieldcontain">
                <span id="name-label" class="property-label"><g:message code="photo.name.label" default="Name"/></span>

                <span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${photoInstance}"
                                                                                        field="name"/></span>

            </li>
        </g:if>

        <g:if test="${photoInstance?.caption}">
            <li class="fieldcontain">
                <span id="caption-label" class="property-label"><g:message code="photo.caption.label"
                                                                           default="Caption"/></span>

                <span class="property-value" aria-labelledby="caption-label"><g:fieldValue bean="${photoInstance}"
                                                                                           field="caption"/></span>

            </li>
        </g:if>

        <g:if test="${photoInstance?.imageData}">
            <li class="fieldcontain">
                <span id="imageData-label" class="property-label"><g:message code="photo.imageData.label"
                                                                             default="Image Data"/></span>

            </li>
        </g:if>

        <g:if test="${photoInstance?.dateCreated}">
            <li class="fieldcontain">
                <span id="dateCreated-label" class="property-label"><g:message code="photo.dateCreated.label"
                                                                               default="Date Created"/></span>

                <span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate
                        date="${photoInstance?.dateCreated}"/></span>

            </li>
        </g:if>

        <g:if test="${photoInstance?.album}">
            <li class="fieldcontain">
                <span id="album-label" class="property-label"><g:message code="photo.album.label"
                                                                         default="Album"/></span>

                <span class="property-value" aria-labelledby="album-label"><g:link controller="album" action="show"
                                                                                   id="${photoInstance?.album?.id}">${photoInstance?.album?.encodeAsHTML()}</g:link></span>

            </li>
        </g:if>

    </ol>
    <g:form>
        <fieldset class="buttons">
            <g:hiddenField name="id" value="${photoInstance?.id}"/>
            <g:link class="edit" action="edit" id="${photoInstance?.id}"><g:message code="default.button.edit.label"
                                                                                    default="Edit"/></g:link>
            <g:actionSubmit class="delete" action="delete"
                            value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
