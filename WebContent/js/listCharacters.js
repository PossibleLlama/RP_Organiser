// Add get requests based on search criteria.
// http://criticalhitpodcast.wikia.com/wiki/Characters

module.exports = function(app) {
    listFromMongo = [{
        characterName : 'Torq',
        playerName : 'Matthew Peterson',
        group: 'Critical Hit',
        campaign: ['Four Against the Void', 'Celestial Crusade', 'Lords of the Feywild'],
        characterClass : [{fighter : 1}],
        characterRace : 'Half Orc',
        description : 'I like funnel cakes. Hit \'em with the pointy end.'
    }];

    app.get('/api/v1/characters', (req, res) => {
        res.send(listFromMongo);
    })
}
