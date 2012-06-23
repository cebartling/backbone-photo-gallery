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

        template:Handlebars.compile($('#tpl-album').html()),

        initialize:function () {
        },

        render:function () {
            $(this.el).html(this.template(this.model.toJSON()));
            return this;
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

}).call(this);



