import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { MeetingComponent } from './meeting/meeting.component';
import { AddMeetingComponent } from './add-meeting/add-meeting.component';
import { PersonalTrainingComponent } from './personal-training/personal-training.component';
import { RegisterComponent } from './register/register.component';


const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'home', component: HomeComponent },
  { path: 'meetings', component: MeetingComponent },
  { path: 'meeting/add/:trainerEmail', component: AddMeetingComponent },
  { path: 'personaltraining', component: PersonalTrainingComponent },
  { path: 'registration', component: RegisterComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
