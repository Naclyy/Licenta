import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginApiService {

  constructor(private http:HttpClient) { }

  public login(username:string, password:string){
    const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username + ":" + password)})
    return this.http.get("http://localhost:8080/", {headers, responseType: 'text' as 'json'});
  }

  public getTrainers(){
    let username = "naclor"
    let password = "1234"
    const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username + ":" + password)})
    return this.http.get("http://localhost:8080/getTrainers", {headers});
  }
}
