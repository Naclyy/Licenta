import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";

@Injectable({
    providedIn: 'root'
})
export class WhatObjectiveService{
    private apiServerUrl = environment.apiBaseUrl;
    private status : any;
    private errorMessage: any;
    constructor(private http: HttpClient){}

    public getTasks(userId: number): Observable<Task[]>{
        return this.http.get<Task[]>(`${this.apiServerUrl}/howTask/findAll/${userId}`);
    }

    public deleteTask(taskId: number): void{
        this.http.delete<void>(`${this.apiServerUrl}/howTask/delete/${taskId}`).subscribe({
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