var mongoose = require('mongoose');
var express = require('express');
var bodyParser = require('body-parser');
var app = express();

app.use(express.static('html'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: false}));

var listCharacter = require('./js/characters')(app, mongoose, bodyParser);

var server = app.listen(3000, () => {
    console.log('Server is on port', server.address().port)
});
