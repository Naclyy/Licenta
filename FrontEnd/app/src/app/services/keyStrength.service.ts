import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { Strength } from "../modules/strength";
@Injectable({
    providedIn: 'root'
})
export class KeyStrengthService{
    private apiServerUrl = environment.apiBaseUrl;
    private status : any;
    private errorMessage: any;
    constructor(private http: HttpClient){}

    public getKeyStrengths(): Observable<Strength[]>{
        const token = (localStorage.getItem('token')||"").toString();
        const headers = { 'Authorization': token , "Access-Control-Allow-Origin": "*" };
        return this.http.get<Strength[]>(`${this.apiServerUrl}/keyStrengths/getAll`, {headers});
    }
}