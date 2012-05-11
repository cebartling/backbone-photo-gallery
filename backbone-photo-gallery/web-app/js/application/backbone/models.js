window.Profile = Backbone.Model.extend({
    url:function () {
        return this.id ? '/profiles/' + this.id : '/profiles';
    }
});

window.ProfileCollection = Backbone.Collection.extend({
    model:Profile,
    url:"/profiles"
});

window.Album = Backbone.Model.extend({});

window.AlbumCollection = Backbone.Collection.extend({

    model:Album,

    initialize:function (props) {
        this.profileId = props.profileId;
    },

    url:function () {
        return '/profiles/' + this.profileId + '/albums';
    }
});




