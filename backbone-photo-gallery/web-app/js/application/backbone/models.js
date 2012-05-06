window.Profile = Backbone.Model.extend({
    url:function () {
        return this.id ? '/profiles/' + this.id : '/profiles';
    }
});

window.ProfileCollection = Backbone.Collection.extend({
    model:Profile,
    url:"/profiles"
});




