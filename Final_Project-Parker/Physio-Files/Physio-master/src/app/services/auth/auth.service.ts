import { Injectable } from '@angular/core';
import { Client } from '../../models/client';
import { ClientService } from '../client/client.service';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  currentClient: Client = {
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
  };

  private currentClientSource;
  globalCurrentClient;
  clients: Client[];
  clientArrayLength = 0;

  constructor(
    private clientService: ClientService
  ) {
    this.getClients();
  }

  getClients() {
    this.clientService.getClients()
    .subscribe(
      clients => {
        console.log(this.clients);
        this.clients = clients;
        this.clientArrayLength = this.clients.length;
      }
    )
  }

  login(clientInfo: Client): boolean {
    this.getClients();
    this.currentClient = new Client();
    console.log(this.clientArrayLength);

    for(var i=0; i < this.clientArrayLength;  i++) {
      console.log("loop");
      if(this.clients[i].name === clientInfo.name && this.clients[i].password === clientInfo.password) {
        console.log("hit");
        this.currentClient = this.clients[i];
        this.setCurrentClient(this.currentClient);
        return true;
      }
    }
  }


  setCurrentClient(client: Client) {
    this.currentClient = client;
    this.currentClientSource = new BehaviorSubject(this.currentClient);
    this.globalCurrentClient = this.currentClientSource.asObservable();
    this.globalCurrentClient.subscribe(
      client => {
        console.log(client);
      }
    )
  }
}
