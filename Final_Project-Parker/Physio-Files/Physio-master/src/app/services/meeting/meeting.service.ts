import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Meeting } from '../../models/meeting';
import { environment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MeetingService {
  private meetingUrl = environment.apiUrl + "meeting/";
  private clientsMeetingsUrl = environment.apiUrl + "meetings/";
  private addMeetingUrl = environment.apiUrl + "meeting/post";

  constructor(
    private http: HttpClient
  ) { }

  getMeeting(meetingName): Observable<Meeting> {
    return this.http.get<Meeting>(this.meetingUrl + meetingName);
  }

  getClientsMeetings(clientsEmail): Observable<Meeting[]> {
    return this.http.get<Meeting[]>(this.clientsMeetingsUrl + clientsEmail);
  }

  addMeeting(meeting: Meeting): Observable<Meeting> {
    console.log(meeting);
    return this.http.post<Meeting>(this.addMeetingUrl, meeting);
  }
}
