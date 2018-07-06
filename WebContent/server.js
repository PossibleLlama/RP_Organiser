var express = require('express');
var app = express();

var listCharacter = require('./js/listCharacters')(app);

app.use(express.static('html'));
var server = app.listen(3000, () => {
    console.log('Server is on port', server.address().port)
});
