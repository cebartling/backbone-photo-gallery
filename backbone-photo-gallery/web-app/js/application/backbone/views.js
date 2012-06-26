(function () {

    window.ProfileView = Backbone.View.extend({

        template:Handlebars.compile($('#tpl-profile-details').html()),

        initialize:function () {
            this.model.on("change", this.render, this);
        },

        render:function (eventName) {
            $(this.el).html(this.template(this.model.toJSON()));
            return this;
        }

    });


    window.AlbumView = Backbone.View.extend({

        tagName:'div',
        className:'well span10',
        events:{
            'click .uploadPhotosButton':'uploadPhotos'
        },

        template:Handlebars.compile($('#tpl-album').html()),

        initialize:function () {
            this.uploadPhotosModel = new UploadPhotosModel({id:this.model.id});
            this.uploadPhotosDialog = new UploadPhotosDialog({model:this.uploadPhotosModel});
        },

        render:function () {
            $(this.el).html('');
            $(this.el).append(this.template(this.model.toJSON()));
            $(this.el).append(this.uploadPhotosDialog.render().el)
            return this;
        },

        uploadPhotos:function (ev) {
            $('#uploadPhotoDialog-' + this.model.id).modal({
                keyboard:false
            });
        }

    });


    window.AlbumListingView = Backbone.View.extend({

        initialize:function () {
            this.collection.on("reset", this.render, this);
        },

        render:function () {
            var self = this;
            _(this.collection.models).each(function (albumModel) {
                var albumView = new AlbumView({model:albumModel});
                $(self.el).append(albumView.render().el)
            });
            return this;
        }

    });

    window.PhotoView = Backbone.View.extend({

        tagName:'div',
        className:'photo',

        template:Handlebars.compile($('#tpl-photo').html()),

        initialize:function () {
        },

        render:function () {
            $(this.el).html(this.template(this.model.toJSON()));
            return this;
        }

    });

    window.PhotoListingView = Backbone.View.extend({

        initialize:function () {
            this.collection.on('reset', this.render, this);
        },

        render:function () {
            var self = this;
            _(this.collection.models).each(function (photoModel) {
                var photoView = new PhotoView({model:photoModel});
                $(self.el).append(photoView.render().el);
            });
            return this;
        }

    });

    window.UploadPhotosDialog = Backbone.View.extend({

        tagName:'div',

        template:Handlebars.compile($('#tpl-upload-photos-dialog').html()),

        initialize:function () {
        },

        render:function () {
            $(this.el).html(this.template(this.model.toJSON()));
            return this;
        }

    });

}).call(this);



