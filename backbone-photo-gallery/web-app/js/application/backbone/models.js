(function () {

    window.Profile = Backbone.Model.extend({

        initialize:function (props) {
            var self = this;
            this.albumCollection = new AlbumCollection({profileId:this.id});
            this.albumCollection.fetch({
                success:function () {
                    self.albumListingView = new AlbumListingView({collection:self.albumCollection});
                    $('#albumListingContent').html(self.albumListingView.render().el);
                }
            });
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
                var self = this;
                this.photoCollection = new PhotoCollection({albumId:this.id});
                this.photoCollection.fetch({
                    success:function () {
                        self.photoListingView = new PhotoListingView({collection:self.photoCollection})
                        $('#photoListingContent-album-' + self.id).html(self.photoListingView.render().el);
                    }
                });
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
        },

        url:function () {
            return this.id ?
                '/albums/' + this.albumId + '/photos' + this.id :
                '/albums/' + this.albumId + '/photos';
        }
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


