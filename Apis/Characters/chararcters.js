var databaseConfigs = require('./resources/dockerConfig.json');

module.exports = function(app, mongoose) {
  mongoose.connect(databaseConfigs.dbUrl, {useNewUrlParser : true}, (err) => {
    if (err) {
      console.log('An error occured.\n', err)
    } else {
      console.log('Mongo db connected.');
    }
  });

  mongoose.Promise = Promise;

}
