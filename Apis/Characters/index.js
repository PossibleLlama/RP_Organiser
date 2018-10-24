var mongoose = require('mongoose');
var express = require('express');
var bodyParser = require('body-parser');
var app = express();

const PORT = 5000;

app.use(express.static('html'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: false}));

var create = require('./chararcters')(app, mongoose, bodyParser);

var server = app.listen(PORT, () => {
    console.log('Server is on port', server.address().port)
});
