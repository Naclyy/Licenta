import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { Skills } from "../modules/skills";
@Injectable({
    providedIn: 'root'
})
export class SkillsService{
    private apiServerUrl = environment.apiBaseUrl;
    private status : any;
    private errorMessage: any;
    constructor(private http: HttpClient){}

    public getSkills(): Observable<Skills[]>{
        return this.http.get<Skills[]>(`${this.apiServerUrl}/skills/getAll`);
    }
}