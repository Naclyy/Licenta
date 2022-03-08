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

    constructor(private http: HttpClient){}

    public getUsers(): Observable<User[]>{
        return this.http.get<User[]>(`${this.apiServerUrl}/user/all`);
    }

    public addUsers(user: User): Observable<User>{
        return this.http.post<User>(`${this.apiServerUrl}/user/add`, user);
    }

    public updateUsers(userId: number, user: User): Observable<User>{
        return this.http.put<User>(`${this.apiServerUrl}/user/update/${userId}`, user);
    }

    public deleteUsers(userId: number): Observable<void>{
        return this.http.delete<void>(`${this.apiServerUrl}/user/delete/${userId}`);
    }
    public testUsers(user: User): Observable<User>{
        return this.http.post<User>(`${this.apiServerUrl}/user/login`, user);
    }
}