(function () {

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

    window.Photo = Backbone.Model.extend({});

    window.PhotoCollection = Backbone.Collection.extend({

        model:Photo,

        initialize:function (props) {
            this.profileId = props.profileId;
            this.albumId = props.albumId;
        },

        url:function () {
            return '/profiles/' + this.profileId + '/albums/' + this.albumId + '/photos';
        }
    });

}).call(this);


