// Add get requests based on search criteria.
// http://criticalhitpodcast.wikia.com/wiki/Characters

module.exports = function(app, mongoose) {
    listFromMongo = [{
        characterName : 'Torq',
        playerName : 'Matthew Peterson',
        group: 'Critical Hit',
        campaign: ['Four Against the Void', 'Celestial Crusade', 'Lords of the Feywild'],
        characterClass : [{fighter : 1}],
        characterRace : 'Half Orc',
        description : 'I like funnel cakes. Hit \'em with the pointy end.'
    }];

    mongoose.connect(dbUrl, {useNewUrlParser : true}, (err) => {
        if (err != null) {
            console.log('An error occured.\n', err)
        } else {
            console.log('Mongo db connected.');
        }
    });
    app.get('/api/v1/characters', (req, res) => {
        res.send(listFromMongo);
    });
}
