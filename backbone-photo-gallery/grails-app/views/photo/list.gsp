<%@ page import="cebartling.backbone.photogallery.domain.Photo" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'photo.label', default: 'Photo')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-photo" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                            default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="list-photo" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>

            <g:sortableColumn property="name" title="${message(code: 'photo.name.label', default: 'Name')}"/>

            <g:sortableColumn property="caption" title="${message(code: 'photo.caption.label', default: 'Caption')}"/>

            <g:sortableColumn property="imageData"
                              title="${message(code: 'photo.imageData.label', default: 'Image Data')}"/>

            <g:sortableColumn property="dateCreated"
                              title="${message(code: 'photo.dateCreated.label', default: 'Date Created')}"/>

            <th><g:message code="photo.album.label" default="Album"/></th>

        </tr>
        </thead>
        <tbody>
        <g:each in="${photoInstanceList}" status="i" var="photoInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td><g:link action="show"
                            id="${photoInstance.id}">${fieldValue(bean: photoInstance, field: "name")}</g:link></td>

                <td>${fieldValue(bean: photoInstance, field: "caption")}</td>

                <td>${fieldValue(bean: photoInstance, field: "imageData")}</td>

                <td><g:formatDate date="${photoInstance.dateCreated}"/></td>

                <td>${fieldValue(bean: photoInstance, field: "album")}</td>

            </tr>
        </g:each>
        </tbody>
    </table>

    <div class="pagination">
        <g:paginate total="${photoInstanceTotal}"/>
    </div>
</div>
</body>
</html>
