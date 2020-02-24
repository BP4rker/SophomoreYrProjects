import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  constructor(private router: Router) {}

  title = 'Physio';

  navLinks = [
    { path: 'weights', label: 'Weightlifting' },
    { path: 'running', label: 'Running' },
    { path: 'personaltraining', label: 'Find Personal Trainers' },
    { path: 'meetings', label: 'Meetings' },
    { path: 'login', label: 'Logout' }
  ];
}
