import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { User } from "../modules/user";
import { Login } from "../modules/login";
import { HttpHeaders } from '@angular/common/http'

@Injectable({
    providedIn: 'root'
})
export class LoginService{
    private apiServerUrl = environment.apiBaseUrl;

    constructor(private http: HttpClient){}
    
    public addUsers(user: User): Observable<User>{
      return this.http.post<User>(`${this.apiServerUrl}/authentication/register`, user);
    }
    public testUsers(login: Login): Observable<Login>{
      return this.http.post<Login>(`${this.apiServerUrl}/authentication/auth`, login);
    }
}