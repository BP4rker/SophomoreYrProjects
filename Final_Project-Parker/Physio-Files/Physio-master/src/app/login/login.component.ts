import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ClientService } from '../services/client/client.service';
import { Client } from '../models/client';
import { FormBuilder, FormGroup, Validators } from  '@angular/forms';
import { AuthService } from '../services/auth/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  clients: Client[];
  loginForm: FormGroup;
  isSubmitted = false;
  isClient = false;
  public currentClient: Client;
  clientArrayLength = 0;
  client: Client;

  constructor(
    private authService: AuthService,
    private clientService: ClientService,
    private router: Router,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit() {
    this.getClients();

    this.loginForm  =  this.formBuilder.group({
      name: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  get formControls() {
    return this.loginForm.controls;
  }

  getClients(): void {
    this.clientService.getClients()
    .subscribe(
      clients => {
        this.clients = clients;
        this.clientArrayLength = clients.length;
        console.log(this.clients);
      }
    )
  }

  login(){
    this.isSubmitted = true;

    if(this.loginForm.invalid){
      return;
    }
    if(this.authService.login(this.loginForm.value) === false) {
      this.isSubmitted = false;
      this.isClient = false;
      return;
    } else {
      this.getClient();
      this.router.navigateByUrl('/meetings');
    }
  }

  getClient() {
    this.clientService.getClient(this.loginForm.get('name').value)
    .subscribe(
      client => {
        if(client == null) {
          console.log("client does not exist");
          this.client = null;
        } else {
          console.log(client);
          this.client = client;

        }
      }
    )
  }
}
