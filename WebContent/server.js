var express = require('express');
var app = express();

app.use(express.static('html'));
var server = app.listen(3000, () => {
    console.log('Server is on port', server.address().port)    
});
