var app = require('../../../express');
var clientModel = require('../model/client.model.server');

app.get('/api/clients', findClients);
app.get('/api/client/:clientName', findClient);
app.get('/api/trainers', findTrainers);
app.post('/api/client/insert', insertClient);

function findClients(req, res) {
  clientModel.findClients().then(
    function(clients) {
      res.send(clients);
    }
  )
}

function findClient(req, res) {
  clientModel.findClient(req.params.clientName).then(
    function(client) {
      if(client.length === 0) {
        console.log("Client Not Found");
        res.send("Client Not Found");
      } else {
        res.send(client);
      }
    }
  )
}

function findTrainers(req, res) {
  clientModel.findTrainers().then(
    function(trainers) {
      if(trainers.length === 0) {
        console.log("Trainers Not Found");
        res.send("Trainers Not Found");
      } else {
        res.send(trainers);
      }
    }
  )
}

function findTrainer(req, res) {
  clientModel.findTrainer(req.params.trainerName).then(
    function(trainer) {
      if(trainer.length === 0) {
        console.log("Trainer Not Found");
        res.send("Trainer Not Found");
      } else {
        res.send(trainer);
      }
    }
  )
}

function insertClient(req, res) {
  var client = req.body;
  console.log(client);
  clientModel.insertClient(client);
}
