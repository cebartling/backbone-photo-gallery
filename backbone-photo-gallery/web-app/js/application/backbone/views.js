window.ProfileView = Backbone.View.extend({

    el:'#profileContent',

    template:Handlebars.compile($('#tpl-profile-details').html()),

    initialize:function () {
        this.model.on("change", this.render, this);
    },

    render:function (eventName) {
        $(this.el).html(this.template(this.model.toJSON()));
        return this;
    }

});


window.AlbumListingView = Backbone.View.extend({

    template:Handlebars.compile($('#tpl-album-listing').html()),

    initialize:function () {
        this.collection.on("reset", this.render, this);
    },

    render:function (eventName) {
        var collectionJSON = this.collection.toJSON();
        $(this.el).html(this.template(collectionJSON));
        return this;
    }

});


