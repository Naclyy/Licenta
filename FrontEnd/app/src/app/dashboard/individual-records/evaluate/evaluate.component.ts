import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
@Component({
  selector: 'app-evaluate',
  templateUrl: './evaluate.component.html',
  styleUrls: ['./evaluate.component.css']
})
export class EvaluateComponent implements OnInit {
  public id : any
  public tasks: Task[] = []
  constructor(private router: Router, private _Activatedroute: ActivatedRoute) { 
  
  }
  ngOnInit(): void {
    this.id = this._Activatedroute.snapshot.paramMap.get("id");
  }
  back(): void{
    this.router.navigate(["dashboard/individual-records"]);
  }
  howObjective(): void{
    this.router.navigate(["dashboard/individual-records/how-objective", this.id]);
  }
  whatObjective(): void{
    this.router.navigate(["dashboard/individual-records/what-objective", this.id]);
  }
}
