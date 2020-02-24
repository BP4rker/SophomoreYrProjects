var mongoose = require('mongoose');
var meetingSchema = require('./meeting.schema.server.js');
var Meeting = mongoose.model('Meeting', meetingSchema);
Meeting.findMeeting = findMeeting;
Meeting.findMeetingByClient = findMeetingByClient;
Meeting.createMeeting = createMeeting;
module.exports = Meeting;

function findMeeting(meetingName) {
  console.log("Meeting Name: " + meetingName);
  return Meeting.find({"name": meetingName})
}

function findMeetingByClient(clientEmail) {
  console.log("Client Email: " + clientEmail);
  return Meeting.find({"clientEmail": clientEmail});
}

function createMeeting(meeting) {
  return Meeting.create(meeting);
}
