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

    public getGraphEstimation(): Observable<EstimateGraph[]>{
        return this.http.get<EstimateGraph[]>(`${this.apiServerUrl}/howTask/graph/1`);
    }
}