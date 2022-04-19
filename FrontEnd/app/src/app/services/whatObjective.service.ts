import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { whatTask } from "../modules/whatTask";
@Injectable({
    providedIn: 'root'
})
export class WhatObjectiveService{
    private apiServerUrl = environment.apiBaseUrl;
    private status : any;
    private errorMessage: any;
    constructor(private http: HttpClient){}

    public getTasks(userId: number): Observable<whatTask[]>{
        return this.http.get<whatTask[]>(`${this.apiServerUrl}/whatTask/findAll/${userId}`);
    }
    public addTask(task: whatTask, userId: number): Observable<whatTask>{
        return this.http.post<whatTask>(`${this.apiServerUrl}/whatTask/add/${userId}`, task);
    }
    public deleteTask(taskId: number): void{
        this.http.delete<void>(`${this.apiServerUrl}/whatTask/delete/${taskId}`).subscribe({
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