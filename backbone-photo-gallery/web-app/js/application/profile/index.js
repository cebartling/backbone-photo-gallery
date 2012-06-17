(function () {

    var profile = new Profile({id:profileId});
    var profileDetails = new ProfileView({el:'#profileContent', model:profile});
    profile.fetch();

    var albumCollection = new AlbumCollection({profileId:profileId});
    var albumListingView = new AlbumListingView({el:'#albumListingContent', collection:albumCollection});
    albumCollection.fetch();


}).call(this);

