<%@ page import="cebartling.backbone.photogallery.domain.Photo" %>



<div class="fieldcontain ${hasErrors(bean: photoInstance, field: 'name', 'error')} required">
    <label for="name">
        <g:message code="photo.name.label" default="Name"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="name" maxlength="80" required="" value="${photoInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: photoInstance, field: 'caption', 'error')} ">
    <label for="caption">
        <g:message code="photo.caption.label" default="Caption"/>

    </label>
    <g:textArea name="caption" cols="40" rows="5" maxlength="4096" value="${photoInstance?.caption}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: photoInstance, field: 'imageData', 'error')} required">
    <label for="imageData">
        <g:message code="photo.imageData.label" default="Image Data"/>
        <span class="required-indicator">*</span>
    </label>
    <input type="file" id="imageData" name="imageData"/>
</div>

<div class="fieldcontain ${hasErrors(bean: photoInstance, field: 'album', 'error')} required">
    <label for="album">
        <g:message code="photo.album.label" default="Album"/>
        <span class="required-indicator">*</span>
    </label>
    <g:select id="album" name="album.id" from="${cebartling.backbone.photogallery.domain.Album.list()}" optionKey="id"
              required="" value="${photoInstance?.album?.id}" class="many-to-one"/>
</div>

