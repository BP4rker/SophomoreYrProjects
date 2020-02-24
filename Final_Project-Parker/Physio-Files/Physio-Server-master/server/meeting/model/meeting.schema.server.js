var mongoose = require('mongoose');
var meetingSchema = new mongoose.Schema(
  {
    "name" : String,
    "date" : String,
    "location" : String,
    "goals" : String,
    "clientEmail" : String,
    "trainerEmail" : String,
  }, {"collection": "meetings"}
)

module.exports = meetingSchema;
