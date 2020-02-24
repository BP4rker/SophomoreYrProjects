import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from  '@angular/forms';
import { ClientService } from '../services/client/client.service';
import { Client } from '../models/client';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  client: Client;
  role = new FormControl(new String(), Validators.required);

  constructor(
    private formBuilder: FormBuilder,
    private clientService: ClientService,
    private router: Router
  ) { }

  ngOnInit() {
    this.registerForm  =  this.formBuilder.group({
      name: ['', Validators.required],
      password: ['', Validators.required],
      email: ['', Validators.required],
      age: ['', Validators.required],
      height: ['', Validators.required],
      weight: ['', Validators.required],
      sport: ['', Validators.required],
      role: this.role,
      location: ['', Validators.required],
      bio: ['', Validators.required],
    });
  }

  submit() {
    if(this.registerForm.invalid) {
      console.log("Invalid");
      console.log(this.registerForm.value)
      return;
    } else {
      this.client = new Client();
      this.client.name = this.registerForm.controls.name.value;
      this.client.password = this.registerForm.controls.password.value;
      this.client.email = this.registerForm.controls.email.value;
      this.client.age = this.registerForm.controls.age.value;
      this.client.height = this.registerForm.controls.height.value;
      this.client.weight = this.registerForm.controls.weight.value;
      this.client.sport = this.registerForm.controls.sport.value;
      this.client.role = this.registerForm.controls.role.value;
      this.client.location = this.registerForm.controls.location.value;
      this.client.bio = this.registerForm.controls.bio.value;

      this.clientService.register(this.client)
      .subscribe(
        client => {
          console.log(client);
        }
      )
    }
    this.router.navigateByUrl('/login');
  }
}
