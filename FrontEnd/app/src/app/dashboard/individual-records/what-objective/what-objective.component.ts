import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { WhatObjectiveService } from 'src/app/services/whatObjective.service';
import { HttpErrorResponse } from '@angular/common/http';
import { whatTask } from 'src/app/modules/whatTask';
import { NgForm } from '@angular/forms';
@Component({
  selector: 'app-what-objective',
  templateUrl: './what-objective.component.html',
  styleUrls: ['./what-objective.component.css']
})
export class WhatObjectiveComponent implements OnInit {
  public id : any
  public tasks: whatTask[] = []
  constructor(private whatObjectiveService: WhatObjectiveService, private router: Router, private _Activatedroute: ActivatedRoute) { 
    
  }
  ngOnInit(): void {
    this.id = this._Activatedroute.snapshot.paramMap.get("id");
    this.getTasks(this.id)
  }
  public getTasks(userId: any): void{
    this.whatObjectiveService.getTasksForUser(userId).subscribe((response: whatTask[]) => {
      console.log(response)
      this.tasks = response;
    }),(error: HttpErrorResponse) => {
      alert(error.message);
    };
  }
  public onOpenModal(): void {

    const container = document.getElementById('main-container');
    const button = document.createElement('button');

    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-bs-toggle', 'modal');
    button.setAttribute('data-bs-target', '#addWhatTaskModal');
    container?.appendChild(button);
    button.click();

  }
  public onAddWhatTask(addForm: NgForm): void{
    this.whatObjectiveService.addTask(addForm.value, this.id).subscribe(
      (response: whatTask) => {
        console.log(response);
        this.tasks.push(response);
      },
      (error: HttpErrorResponse) => {
        alert(error.error.message)
      }
    );
    document.getElementById('add-user-form')?.click();
  }
  public deleteTask(taskId: any): void{
    this.whatObjectiveService.deleteTask(this.tasks[taskId].taskId);
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
