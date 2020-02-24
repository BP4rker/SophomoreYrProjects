var mongoose = require('mongoose');
var clientSchema = new mongoose.Schema(
  {
    "name" : String,
    "password" : String,
    "email" : String,
    "age" : Number,
    "height" : Number,
    "weight" : Number,
    "sport" : String,
    "role" : String,
    "location" : String,
    "bio": String
  }, {"collection": "clients"}
)

module.exports = clientSchema;
