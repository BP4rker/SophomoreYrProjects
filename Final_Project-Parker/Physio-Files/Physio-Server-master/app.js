console.log("SERVER SIDE");
var app = require('./express'); // creates an instance of the express lib
var express = app.express;
var mongoose = require('mongoose');
var cors = require('cors');
var env = require('dotenv').config();
var connectionString = process.env.DATABASE_URL + "physio";
app.use(cors());
app.use(express.json());
console.log(connectionString)
console.log("connecting with: " + connectionString);

mongoose.connect(connectionString);

require("./server/client/services/client.service.server");
require("./server/meeting/services/meeting.service.server");
app.listen(3000)
module.exports = express;
