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
        return this.http.get<User[]>(`${this.apiServerUrl}/user/all`);
    }

    public addUsers(user: User): Observable<User>{
        return this.http.post<User>(`${this.apiServerUrl}/user/add`, user);
    }

    public updateUsers(userId: number, user: User): Observable<User>{
        return this.http.put<User>(`${this.apiServerUrl}/user/update/${userId}`, user);
    }
    public findUSerById(userId:number): Observable<User>{
        return this.http.get<User>(`${this.apiServerUrl}/user/find/${userId}`);
    }
    public deleteUsers(userId: number): void{
        this.http.delete<void>(`${this.apiServerUrl}/user/delete/${userId}`).subscribe({
            next: data => {
                this.status = 'Delete successful';
            },
            error: error => {
                this.errorMessage = error.message;
                console.error('There was an error!', error);
            }
        });
    }
    public testUsers(user: User): Observable<User>{
        return this.http.post<User>(`${this.apiServerUrl}/user/login`, user);
    }
}