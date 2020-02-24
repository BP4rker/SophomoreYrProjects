import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Client } from '../../models/client';
import { environment } from '../../../environments/environment';


@Injectable({
  providedIn: 'root'
})
export class ClientService {
  private clientsUrl = environment.apiUrl + 'clients';
  private clientUrl = environment.apiUrl + 'client/';
  private trainerUrl = environment.apiUrl + 'trainers';
  private postClientUrl = environment.apiUrl + 'client/insert';

  constructor(
    private http: HttpClient
  ) { }

  getClients(): Observable<Client[]> {
    return this.http.get<Client[]>(this.clientsUrl)
  }

  getClient(clientName): Observable<Client> {
    return this.http.get<Client>(this.clientUrl + clientName);
  }

  getTrainers(): Observable<Client[]> {
    return this.http.get<Client[]>(this.trainerUrl);
  }

  getTrainer(trainerName): Observable<Client> {
    return this.http.get<Client>(this.clientUrl + trainerName);
  }

  register(client: Client): Observable<Client> {
    return this.http.post<Client>(this.postClientUrl, client)
  }
}
