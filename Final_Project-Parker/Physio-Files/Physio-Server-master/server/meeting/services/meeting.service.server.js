var app = require('../../../express');
var meetingModel = require('../model/meeting.model.server');

app.get('/api/meeting/:meetingName', findMeeting);
app.get('/api/meetings/:clientEmail', findMeetingByClient);
app.post('/api/meeting/post', createMeeting);

function findMeeting(req, res) {
  meetingModel.findMeeting(req.params.meetingName).then(
    function(meeting) {
      console.log(meeting);
      if(meeting.length === 0) {
        console.log("Meeting Not Found");
        res.send("Meeting Not Found");
      } else {
        res.send(meeting);
      }
    }
  )
}

function findMeetingByClient(req, res) {
  meetingModel.findMeetingByClient(req.params.clientEmail).then(
    function(meetings) {
      console.log(meetings);
      if(meetings.length === 0) {
        console.log("Meetings for client not found");
        res.send("Meetings for client not found");
      } else {
        res.send(meetings);
      }
    }
  )
}

function createMeeting(req, res) {
  var meeting = req.body;
  console.log(meeting);
  meetingModel.createMeeting(meeting);
}
