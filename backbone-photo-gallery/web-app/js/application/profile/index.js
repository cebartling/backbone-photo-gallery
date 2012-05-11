var profile = new Profile({id:profileId});
var profileDetails = new ProfileView({model:profile})
profile.fetch();

var albumCollection = new AlbumCollection({profileId:profileId});
var albumListingView = new AlbumListingView({collection:albumCollection, el:'#albumListingContent'});
albumCollection.fetch();
