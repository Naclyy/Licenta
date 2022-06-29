import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { User } from "../modules/user";
import { Login } from "../modules/login";
import { HttpHeaders } from '@angular/common/http'
import { map } from "rxjs";
@Injectable({
    providedIn: 'root'
})
export class LoginService{
    private apiServerUrl = environment.apiBaseUrl;

    constructor(private http: HttpClient){}
    
    public addUsers(user: User): Observable<User>{
      const token = (localStorage.getItem('token')||"").toString();
      const headers = { 'Authorization': token , "Access-Control-Allow-Origin": "*" };
      return this.http.post<User>(`${this.apiServerUrl}/authentication/register`, user, {headers});
    }
    public testUsers(login: Login){
      return this.http.post<any>(`${this.apiServerUrl}/login`, login, {observe: 'response'}).pipe(map((resp) => {
        localStorage.setItem('token',(resp.headers.get('expires') || "").toString());
    }));
    }
}