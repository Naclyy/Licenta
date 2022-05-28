import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { addHowTask } from "../modules/addHowTask";
import { howTask } from "../modules/howTask";
@Injectable({
    providedIn: 'root'
})
export class HowObjectiveService{
    private apiServerUrl = environment.apiBaseUrl;
    private status : any;
    private errorMessage: any;
    constructor(private http: HttpClient){}

    public getTasks(userId: number): Observable<howTask[]>{
        const token = (localStorage.getItem('token')||"").toString();
        const headers = { 'Authorization': token , "Access-Control-Allow-Origin": "*" };
        return this.http.get<howTask[]>(`${this.apiServerUrl}/howTask/findAll/${userId}`, {headers});
    }
    public getAllTasksForWhatId(whatId: number): Observable<howTask[]>{
        const token = (localStorage.getItem('token')||"").toString();
        const headers = { 'Authorization': token , "Access-Control-Allow-Origin": "*"};
        return this.http.get<howTask[]>(`${this.apiServerUrl}/howTask/findAllWhatId/${whatId}`, {headers});
    } 
    public addTask(task: addHowTask, userId: number, whatId: number): Observable<howTask>{
        const token = (localStorage.getItem('token')||"").toString();
        const headers = { 'Authorization': token , "Access-Control-Allow-Origin": "*"};
        return this.http.post<howTask>(`${this.apiServerUrl}/howTask/add/${userId}/${whatId}`, task, {headers});
    }
    public addPredecessor(predecessorId: number): void{
        const token = (localStorage.getItem('token')||"").toString();
        const headers = { 'Authorization': token , "Access-Control-Allow-Origin": "*" };
        console.log("ce se intampla")
        this.http.post<void>(`${this.apiServerUrl}/howTask/addPredecessor/`, predecessorId, {headers}).subscribe({
            next: data => {
                this.status = 'Delete successful';
            },
            error: error => {
                this.errorMessage = error.message;
                console.error('There was an error!', error);
            }
        });
    }
    public deleteTask(taskId: number): void{
        const token = (localStorage.getItem('token')||"").toString();
        const headers = { 'Authorization': token , "Access-Control-Allow-Origin": "*" };
        this.http.delete<void>(`${this.apiServerUrl}/howTask/delete/${taskId}`, {headers}).subscribe({
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