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

window.ProfileToolbarView = Backbone.View.extend({

    tagName:'div',

    events:{
        'click .showButton':'show',
        'click .editButton':'edit',
        'click .addButton':'add',
        'click .deleteButton':'delete'
    },

    template:Handlebars.compile($('#tpl-profile-toolbar').html()),

    render:function (eventName) {
        var json = this.model.toJSON();
        $(this.el).html(this.template(json));
        return this;
    },

    show:function (e) {
        alert('This is the show function.');
        return false;
    },

    edit:function (e) {
        alert('This is the edit function.');
        return false;
    },

    add:function (e) {
        alert('This is the add function.');
        return false;
    },

    delete:function (e) {
        alert('This is the delete function.');
        return false;
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
        this.profileToolbarView = new ProfileToolbarView({model:this.profileList});
        this.profileList.fetch();
        $('#profilesContainer').html(this.profileListView.render().el);
        $('#toolbarContainer').html(this.profileToolbarView.render().el);
    },

    profileDetails:function (id) {
        if (this.profileList !== undefined) {
            this.profile = this.profileList.get(id);
            this.profileView = new ProfileView({model:this.profile});
            $('#profileDetailsContainer').html(this.profileView.render().el);
        }
    }
});

var app = new AppRouter();
Backbone.history.start();