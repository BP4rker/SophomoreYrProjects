import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';
import { Client } from '../../models/client';
import { ClientService } from '../../services/client/client.service';
import { AuthService } from '../../services/auth/auth.service';
import { PersonalTrainingComponent } from '../personal-training.component';

@Component({
  selector: 'app-training-grid',
  templateUrl: './training-grid.component.html',
  styleUrls: ['./training-grid.component.css']
})
export class TrainingGridComponent implements OnInit {
  trainers: Client[];
  trainer: Client;
  displayedColumns: string[] = ['name', 'age', 'sport'];

  @Output() seeTrainer = new EventEmitter<Client>();

  constructor(
    private authService: AuthService,
    private clientService: ClientService,
    private router: Router,
  ) { }

  ngOnInit() {
    this.getTrainers();
  }

  getTrainers() {
    this.clientService.getTrainers().subscribe(
      trainers => {
        console.log(trainers);
        this.trainers = trainers;
      }
    )
  }

  getTrainer(name) {
    this.clientService.getTrainer(name).subscribe(
      trainer => {
        this.trainer = trainer;
        this.seeTrainer.emit(this.trainer);
      }
    )
  }
}
