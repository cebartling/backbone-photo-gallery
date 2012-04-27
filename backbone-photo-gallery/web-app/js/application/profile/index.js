/**********************************************************************/
/** /js/application/profile/index.js                                 **/
/**********************************************************************/


// Models
window.Profile = Backbone.Model.extend();

window.ProfileCollection = Backbone.Collection.extend({
    model:Profile,
    url:"/profiles"
});

// Views
window.ProfileListView = Backbone.View.extend({

    tagName:'ul',

    initialize:function () {
        this.model.bind("reset", this.render, this);
    },

    render:function (eventName) {
        _.each(this.model.models, function (profile) {
            $(this.el).append(new ProfileListItemView({model:profile}).render().el);
        }, this);
        return this;
    }

});

window.ProfileListItemView = Backbone.View.extend({

    tagName:"li",

    template:Handlebars.compile($('#tpl-profile-list-item').html()),

    render:function (eventName) {
        var json = this.model.toJSON();
        $(this.el).html(this.template(json));
        return this;
    }

});

window.ProfileView = Backbone.View.extend({

    template:Handlebars.compile($('#tpl-profile-details').html()),

    render:function (eventName) {
        $(this.el).html(this.template(this.model.toJSON()));
        return this;
    }

});

// Router
var AppRouter = Backbone.Router.extend({

    routes:{
        "":"list",
        "profiles/:id":"profileDetails"
    },

    list:function () {
        this.profileList = new ProfileCollection();
        this.profileListView = new ProfileListView({model:this.profileList});
        this.profileList.fetch();
        $('#profilesContainer').html(this.profileListView.render().el);
    },

    profileDetails:function (id) {
        this.profile = this.profileList.get(id);
        this.profileView = new ProfileView({model:this.profile});
        $('#profileDetailsContainer').html(this.profileView.render().el);
    }
});

var app = new AppRouter();
Backbone.history.start();