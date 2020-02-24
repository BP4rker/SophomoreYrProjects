import { Component, OnInit } from '@angular/core';
import { Meeting } from '../models/meeting';
import { MeetingService } from '../services/meeting/meeting.service';
import { AuthService } from '../services/auth/auth.service';
import { Client } from '../models/client';

@Component({
  selector: 'app-meeting',
  templateUrl: './meeting.component.html',
  styleUrls: ['./meeting.component.scss']
})
export class MeetingComponent implements OnInit {
  client: Client;
  meeting: Meeting;
  meetings: Meeting[];
  displayedColumns: string[] = [
    'name',
    'date',
    'location',
    'goals',
    'clientEmail',
    'trainerEmail'
  ];

  constructor(
    private meetingService: MeetingService,
    private authService: AuthService
  ) { }

  ngOnInit() {
    this.authService.globalCurrentClient.subscribe(client => this.client = client);
    this.getClientsMeetings(this.client.email);
  }

  getMeeting(meetingName) {
    this.meetingService.getMeeting(meetingName)
    .subscribe(
      meeting => {
        console.log(meeting);
        this.meeting = meeting;
      }
    )
  }

  getClientsMeetings(clientsEmail) {
    this.meetingService.getClientsMeetings(clientsEmail)
    .subscribe(
      meetings => {
        console.log(meetings);
        this.meetings = meetings;
      }
    )
  }
}
