import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { WhatObjectiveService } from 'src/app/services/whatObjective.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Task } from 'src/app/modules/task';
@Component({
  selector: 'app-what-objective',
  templateUrl: './what-objective.component.html',
  styleUrls: ['./what-objective.component.css']
})
export class WhatObjectiveComponent implements OnInit {
  public id : any
  public tasks: Task[] = []
  constructor(private howObjectiveService: WhatObjectiveService, private router: Router, private _Activatedroute: ActivatedRoute) { 
    
  }
  ngOnInit(): void {
    this.id = this._Activatedroute.snapshot.paramMap.get("id");
    this.getTasks(this.id)
  }
  public getTasks(userId: any): void{
    this.howObjectiveService.getTasks(userId).subscribe((response: any[]) => {
      console.log(response)
      this.tasks = response;
    }),(error: HttpErrorResponse) => {
      alert(error.message);
    };
  }
  public deleteTask(taskId: any): void{
    this.howObjectiveService.deleteTask(this.tasks[taskId].taskId);
    this.tasks.splice(taskId, 1);
  }
  back(): void{
    this.router.navigate(["dashboard/individual-records"]);
  }
  howObjective(): void{
    this.router.navigate(["dashboard/individual-records/how-objective", this.id]);
  }
  evaluate(): void{
    this.router.navigate(["dashboard/individual-records/evaluate", this.id]);
  }
}
