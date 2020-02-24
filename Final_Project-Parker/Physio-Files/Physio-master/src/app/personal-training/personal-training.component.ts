import { Component, OnInit } from '@angular/core';
import { SelectionModel } from '@angular/cdk/collections';
import { Router } from '@angular/router';
import { Client } from '../models/client';
import { ClientService } from '../services/client/client.service';
import { AuthService } from '../services/auth/auth.service';
import { TrainingGridComponent } from './training-grid/training-grid.component';

@Component({
  selector: 'app-personal-training',
  templateUrl: './personal-training.component.html',
  styleUrls: ['./personal-training.component.css']
})
export class PersonalTrainingComponent implements OnInit {
  trainer: Client[] = [{
      _id: "",
      name: "",
      password: "",
      email: "",
      age: null,
      height: null,
      weight: null,
      sport: "",
      role: "",
      location: "",
      bio: ""
  }];

  constructor() { }

  ngOnInit() { }

  receiveTrainer($event) {
    console.log($event);
    this.trainer = $event;
  }
}
