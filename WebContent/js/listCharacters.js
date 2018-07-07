// Add get requests based on search criteria.
// http://criticalhitpodcast.wikia.com/wiki/Characters
var databaseConfigs = require('./../resources/mlabDatabase.json');

module.exports = function(app, mongoose) {
    var Character = mongoose.model('Character', {
        characterName: String,
        playerName: String,
        group: String,
        campaign: [String],
        characterClass: [{String, Number}],
        characterRace: String,
        characterSheet: [{String, String}],
        notes: String
    });

    mongoose.connect(databaseConfigs.dbUrl, {useNewUrlParser : true}, (err) => {
        if (err) {
            console.log('An error occured.\n', err)
        } else {
            console.log('Mongo db connected.');
        }
    });

    app.get('/api/v1/characters', (req, res) => {
        res.send(listFromMongo);
        var character = new Character(res.body);
    });
}
