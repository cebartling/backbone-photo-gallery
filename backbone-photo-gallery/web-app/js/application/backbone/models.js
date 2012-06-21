(function () {

    window.Profile = Backbone.Model.extend({
        initialize:function (props) {
            this.albumCollection = new AlbumCollection({profileId:this.id});
            this.albumListingView = new AlbumListingView({el:'#albumListingContent', collection:this.albumCollection});
            this.albumCollection.fetch();
        },
        url:function () {
            return this.id ? '/profiles/' + this.id : '/profiles';
        }
    });

    window.ProfileCollection = Backbone.Collection.extend({
        model:Profile,
        url:"/profiles"
    });

    window.Album = Backbone.Model.extend({
        initialize:function (props) {
            if (this.id) {
                this.photoCollection = new PhotoCollection({albumId:this.id});
//            this.albumListingView = new Ph({el:'#albumListingContent', collection:this.albumCollection});
                this.photoCollection.fetch();
            }
        },
        url:function () {
            return this.id ?
                '/profiles/' + this.profileId + '/albums/' + this.id :
                '/profiles/' + this.profileId + '/albums';
        }
    });

    window.AlbumCollection = Backbone.Collection.extend({

        model:Album,

        initialize:function (props) {
            this.profileId = props.profileId;
        },

        url:function () {
            return '/profiles/' + this.profileId + '/albums';
        }
    });

    window.Photo = Backbone.Model.extend({
        initialize:function (props) {
        }
//        ,
//        url:function () {
//            return this.id ?
//                '/profiles/' + this.profileId + '/albums/' + this.id :
//                '/profiles/' + this.profileId + '/albums';
//        }
    });

    window.PhotoCollection = Backbone.Collection.extend({

        model:Photo,

        initialize:function (props) {
            this.albumId = props.albumId;
        },

        url:function () {
            return '/albums/' + this.albumId + '/photos';
        }
    });

}).call(this);


