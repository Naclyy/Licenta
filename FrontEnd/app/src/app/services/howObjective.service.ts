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
        return this.http.get<howTask[]>(`${this.apiServerUrl}/howTask/findAll/${userId}`);
    }
    public getAllTasksForWhatId(whatId: number): Observable<howTask[]>{
        return this.http.get<howTask[]>(`${this.apiServerUrl}/howTask/findAllWhatId/${whatId}`);
    } 
    public addTask(task: addHowTask, userId: number, whatId: number): Observable<howTask>{
        return this.http.post<howTask>(`${this.apiServerUrl}/howTask/add/${userId}/${whatId}`, task);
    }
    public addPredecessor(howId: number, predecessorId: number): void{
        console.log("intra??")
        this.http.post<void>(`${this.apiServerUrl}/howTask/addPredecessor/${howId}`, predecessorId).subscribe({
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