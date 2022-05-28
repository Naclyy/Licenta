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

    public getTasksForUser(userId: number): Observable<whatTask[]>{
        const token = (localStorage.getItem('token')||"").toString();
        const headers = { 'Authorization': token , "Access-Control-Allow-Origin": "*" };
        return this.http.get<whatTask[]>(`${this.apiServerUrl}/whatTask/findAllForUser/${userId}`, {headers});
    }
    public getAllTasks():Observable<whatTask[]>{
        const token = (localStorage.getItem('token')||"").toString();
        const headers = { 'Authorization': token , "Access-Control-Allow-Origin": "*" };
        return this.http.get<whatTask[]>(`${this.apiServerUrl}/whatTask/findAll`, {headers});
    }

    public addTask(task: whatTask): Observable<whatTask>{
        const token = (localStorage.getItem('token')||"").toString();
        const headers = { 'Authorization': token , "Access-Control-Allow-Origin": "*"};
        return this.http.post<whatTask>(`${this.apiServerUrl}/whatTask/add`, task, {headers});
    }
    public addTaskToUser(taskId: number, userId: number): Observable<whatTask>{
        const token = (localStorage.getItem('token')||"").toString();
        const headers = { 'Authorization': token , "Access-Control-Allow-Origin": "*"};
        return this.http.post<whatTask>(`${this.apiServerUrl}/whatTask/addToUser/${userId}`, taskId, {headers});
    }
    public deleteTask(taskId: number): void{
        const token = (localStorage.getItem('token')||"").toString();
        const headers = { 'Authorization': token , "Access-Control-Allow-Origin": "*"};
        this.http.delete<void>(`${this.apiServerUrl}/whatTask/delete/${taskId}`, {headers}).subscribe({
            next: data => {
                this.status = 'Delete successful';
            },
            error: error => {
                this.errorMessage = error.message;
                console.error('There was an error!', error);
            }
        });
    }

    public deleteTaskFromUser(taskId: number, userId: number): any{
        const token = (localStorage.getItem('token')||"").toString();
        const headers = { 'Authorization': token , "Access-Control-Allow-Origin": "*"};
        return this.http.post<any>(`${this.apiServerUrl}/whatTask/deleteFromUser/${userId}`,taskId, {headers});
    }
}