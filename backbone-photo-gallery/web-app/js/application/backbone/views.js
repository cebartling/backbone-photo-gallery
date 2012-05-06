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


