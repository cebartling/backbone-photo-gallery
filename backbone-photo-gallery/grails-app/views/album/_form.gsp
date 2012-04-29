<%@ page import="cebartling.backbone.photogallery.domain.Album" %>



<div class="fieldcontain ${hasErrors(bean: albumInstance, field: 'name', 'error')} required">
    <label for="name">
        <g:message code="album.name.label" default="Name"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textArea name="name" cols="40" rows="5" maxlength="1024" required="" value="${albumInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: albumInstance, field: 'profile', 'error')} required">
    <label for="profile">
        <g:message code="album.profile.label" default="Profile"/>
        <span class="required-indicator">*</span>
    </label>
    <g:select id="profile" name="profile.id" from="${cebartling.backbone.photogallery.domain.Profile.list()}"
              optionKey="id" required="" value="${albumInstance?.profile?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: albumInstance, field: 'albums', 'error')} ">
    <label for="albums">
        <g:message code="album.albums.label" default="Albums"/>

    </label>
    <g:select name="albums" from="${cebartling.backbone.photogallery.domain.Album.list()}" multiple="multiple"
              optionKey="id" size="5" value="${albumInstance?.albums*.id}" class="many-to-many"/>
</div>

