import { Injectable } from '@angular/core';
// import HttpClient to make http requests
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SecurityService } from './security.service';
@Injectable({
  providedIn: 'root'
})
export class DiagnosticService {

  constructor(private http: HttpClient, private securityService: SecurityService) { }

  // Make call to http://localhost:8085/api/v1/user/register
  public register(userName: String, password: String): Observable<any> {
    return this.http.post('http://localhost:8085/api/v1/user/register', {
      userName,
      password
    });
  }
  
  // make call to http://localhost:8085/api/v1/user/login
  public login(userName: String, password: String): Observable<any> {
    return this.http.post('http://localhost:8085/api/v1/user/login', {
      userName,
      password
    });
  }

  // Make call to http://localhost:8085/api/v1/diagnostic/
  public getAllDiagnostic(): Observable<any> {
    return this.http.get('http://localhost:8085/api/v1/diagnostic/');
  }

  // Make call to http://localhost:8085/api/v1/diagnostic/{id}
  getDiagnosticById(id: any): Observable<any> {
    return this.http.get(`http://localhost:8085/api/v1/diagnostic/${id}`);
  }

  // Make HTTP post request to http://localhost:8085/api/v1/appointment/ by sending appointment object
  public createAppointment(appointment: any): Observable<any> {
    return this.http.post('http://localhost:8085/api/v1/appointment/', appointment);
  }

  // Make HTTP get request to http://localhost:8085/api/v1/appointment/ to get all appointments
  public getAllAppointment(): Observable<any> {
    return this.http.get('http://localhost:8085/api/v1/appointment/');
  }

  // Make Http PUT request http://localhost:8085/api/v1/appointment/ sending updated appointment object
  public updateAppointment(appointment: any): Observable<any> {
    return this.http.put('http://localhost:8085/api/v1/appointment/', appointment);
  }

  // Make HTTP DELETE request to http://localhost:8085/api/v1/appointment/{id}
  public deleteAppointment(id: any): Observable<any> {
    return this.http.delete(`http://localhost:8085/api/v1/appointment/${id}`);
  }
  
}
