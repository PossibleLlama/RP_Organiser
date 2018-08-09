// Add get requests based on search criteria.
// http://criticalhitpodcast.wikia.com/wiki/Characters
var databaseConfigs = require('./../resources/mlabDatabase.json');

module.exports = function(app, mongoose) {
    mongoose.connect(databaseConfigs.dbUrl, {useNewUrlParser : true}, (err) => {
        if (err) {
            console.log('An error occured.\n', err)
        } else {
            console.log('Mongo db connected.');
        }
    });

    mongoose.Promise = Promise;

    var Character = mongoose.model('Character', {
        characterName: String,
        playerName: String,
        group: String,
        system: String,
        campaign: [String],
        characterClass: [{
            class: String,
            level: Number
        }],
        characterRace: String,
        characterSheet: {
            url: String,
            level: Number,
            version: Number
        },
        notes: String
    });

    app.get('/api/v1/characters', (req, res) => {
        Character.find({}, (err, characters) => {
            if (err) res.sendStatus(500);
            res.send(characters);
        });
    });

    app.post('/api/v1/characters', async (req, res) => {
        try {
            var character = new Character(req.body);
            await character.save();
            res.sendStatus(201);
        } catch (err) {
            res.sendStatus(500);
        }
    });
}
