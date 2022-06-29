import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { User } from "./modules/user";

@Injectable({
    providedIn: 'root'
})
export class UserService{
    private apiServerUrl = environment.apiBaseUrl;
    private status : any;
    private errorMessage: any;
    constructor(private http: HttpClient){}

    public getUsers(): Observable<User[]>{
        const token = (localStorage.getItem('token')||"").toString();
        const headers = { 'Authorization': token , 
        "Access-Control-Allow-Origin": "*",
       };
        return this.http.get<User[]>(`${this.apiServerUrl}/user/all`, {headers});
    }

    public addUsers(user: User): Observable<User>{
        const token = (localStorage.getItem('token')||"").toString();
        const headers = { 'Authorization': token , "Access-Control-Allow-Origin": "*"};
        return this.http.post<User>(`${this.apiServerUrl}/user/add`, user, {headers});
    }

    public updateUsers(userId: number, user: User): Observable<User>{
        const token = (localStorage.getItem('token')||"").toString();
        const headers = { 'Authorization': token , "Access-Control-Allow-Origin": "*"};
        return this.http.put<User>(`${this.apiServerUrl}/user/update/${userId}`, user, {headers});
    }
    public findUSerById(userId:number): Observable<User>{
        const token = (localStorage.getItem('token')||"").toString();
        const headers = { 'Authorization': token , "Access-Control-Allow-Origin": "*" };
        return this.http.get<User>(`${this.apiServerUrl}/user/find/${userId}`, {headers});
    }
    public deleteUsers(userId: number): void{
        const token = (localStorage.getItem('token')||"").toString();
        const headers = { 'Authorization': token , "Access-Control-Allow-Origin": "*" };
        this.http.delete<void>(`${this.apiServerUrl}/user/delete/${userId}`, {headers}).subscribe({
            next: data => {
                this.status = 'Delete successful';
            },
            error: error => {
                this.errorMessage = error.message;
                console.error('There was an error!', error);
            }
        });
    }
}