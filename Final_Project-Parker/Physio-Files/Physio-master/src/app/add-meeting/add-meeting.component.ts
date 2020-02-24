import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup ,Validators} from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Meeting } from '../models/meeting';
import { Client } from '../models/client';
import { ClientService } from '../services/client/client.service';
import { AuthService } from '../services/auth/auth.service';
import { MeetingService } from '../services/meeting/meeting.service';

@Component({
  selector: 'app-add-meeting',
  templateUrl: './add-meeting.component.html',
  styleUrls: ['./add-meeting.component.scss']
})
export class AddMeetingComponent implements OnInit {
  meetingForm: FormGroup;
  client: Client;
  trainers: Client[];
  meeting: Meeting;
  trainerEmail;

  constructor(
    private authService: AuthService,
    private clientService: ClientService,
    private router: Router,
    private formBuilder: FormBuilder,
    private meetingService: MeetingService,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.getTrainers();
    this.authService.globalCurrentClient.subscribe(client => this.client = client);
    this.trainerEmail = this.route.snapshot.params['trainerEmail'];

    this.meetingForm = this.formBuilder.group({
      name: ['', Validators.required],
      date: [new Date(), Validators.required],
      location: ['', Validators.required],
      goals: ['', Validators.required],
      clientEmail: this.client.email,
      trainerEmail: this.trainerEmail
    })

  }

  getTrainers() {
    this.clientService.getTrainers().subscribe(
      trainers => {
        console.log(trainers);
        this.trainers = trainers;
      }
    )
  }

  submit() {
    if(this.meetingForm.invalid) {
      return;
    } else {
      this.meeting = new Meeting();
      this.meeting.name = this.meetingForm.controls.name.value;
      this.meeting.date = this.meetingForm.controls.date.value;
      this.meeting.location = this.meetingForm.controls.location.value;
      this.meeting.goals = this.meetingForm.controls.goals.value;
      this.meeting.clientEmail = this.meetingForm.controls.clientEmail.value;
      this.meeting.trainerEmail = this.meetingForm.controls.trainerEmail.value;

      this.meetingService.addMeeting(this.meeting)
      .subscribe(
        meeting => {
          console.log(meeting);
        }
      )
      this.router.navigateByUrl('/meetings');
    }
  }
}
