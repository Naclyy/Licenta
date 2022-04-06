import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HowObjectiveService } from 'src/app/services/howObjective.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Task } from 'src/app/modules/task';
import { ThrowStmt } from '@angular/compiler';
@Component({
  selector: 'app-how-objective',
  templateUrl: './how-objective.component.html',
  styleUrls: ['./how-objective.component.css']
})
export class HowObjectiveComponent implements OnInit {
  public id : any
  public tasks: Task[] = []
  constructor(private howObjectiveService: HowObjectiveService, private router: Router, private _Activatedroute: ActivatedRoute) { 
    
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
  whatObjective(): void{
    this.router.navigate(["dashboard/individual-records/what-objective", this.id]);
  }
  evaluate(): void{
    this.router.navigate(["dashboard/individual-records/evaluate", this.id]);
  }
}
