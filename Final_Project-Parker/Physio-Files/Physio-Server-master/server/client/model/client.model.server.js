var mongoose = require('mongoose');
var clientSchema = require('./client.schema.server');
var Client = mongoose.model('Client', clientSchema);
Client.findClients = findClients;
Client.findClient = findClient;
Client.findTrainers = findTrainers;
Client.insertClient = insertClient;
module.exports = Client;

function findClients() {
  return Client.find({});
}

function findClient(clientName) {
  console.log("Client Name: " + clientName);
  return Client.find({"name": clientName})
}

function findTrainers() {
  console.log("Finding Trainers");
  return Client.find({"role": "trainer"});
}

function insertClient(client) {
  return Client.create(client);
}
