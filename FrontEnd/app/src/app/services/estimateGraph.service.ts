import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { EstimateGraph } from "../modules/estimateGraph";
@Injectable({
    providedIn: 'root'
})
export class EstimateGraphService{
    private apiServerUrl = environment.apiBaseUrl;
    private status : any;
    private errorMessage: any;
    constructor(private http: HttpClient){}

    public getGraphEstimation(id: number): Observable<EstimateGraph[]>{
        const token = (localStorage.getItem('token')||"").toString();
        const headers = { 'Authorization': token , "Access-Control-Allow-Origin": "*"};
        return this.http.get<EstimateGraph[]>(`${this.apiServerUrl}/howTask/graph/${id}`, {headers});
    }
}