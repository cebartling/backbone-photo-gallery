(function () {

    var profile = new Profile({id:profileId});
    var profileDetails = new ProfileView({el:'#profileContent', model:profile});
    profile.fetch();

}).call(this);

