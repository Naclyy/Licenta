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
  public user_tasks: whatTask[] = []
  public what_tasks: whatTask[] = []
  public selectedTask : boolean = true;
  constructor(private whatObjectiveService: WhatObjectiveService, private router: Router, private _Activatedroute: ActivatedRoute) { 
    
  }
  ngOnInit(): void {
    this.id = this._Activatedroute.snapshot.paramMap.get("id");
    this.getTasks(this.id)
  }
  public getTasks(userId: any): void{
    this.whatObjectiveService.getTasksForUser(userId).subscribe((response: whatTask[]) => {
      console.log(response)
      this.user_tasks = response;
    }),(error: HttpErrorResponse) => {
      alert(error.message);
    };
    this.whatObjectiveService.getAllTasks().subscribe((response: whatTask[]) => {
      console.log(response)
      this.what_tasks = response;
    }),(error: HttpErrorResponse) => {
      alert(error.message);
    };
  }
  testAddTask(): number{
    const selected = <HTMLVideoElement>document.querySelector(".selected");
    const choosen_task = selected.innerHTML;
    for(let i = 0; i < this.user_tasks.length; i++)
      if(this.user_tasks[i].objective == choosen_task){
        alert("The user already has this task")
        this.selectedTask = true;
        return -1
      }
    for(let i = 0; i < this.what_tasks.length; i++)
      if(this.what_tasks[i].objective == choosen_task)
        return this.what_tasks[i].taskId;
    return -1
    
  }
  public selectTask(task: any):void {
    const optionsContainer = <HTMLVideoElement>document.querySelector(".options-container")
    const selected = <HTMLVideoElement>document.querySelector(".selected");
    selected.innerHTML = task;
    optionsContainer.classList.remove("active");
    this.selectedTask = false;
  }
  openDropDown():void {
    const optionsContainer = <HTMLVideoElement>document.querySelector(".options-container")
    optionsContainer.classList.toggle("active");
  }
  checkSelected(): boolean{
    return this.selectedTask
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
  public onAddWhatTask(): void{
    if(this.testAddTask() != -1){
      this.whatObjectiveService.addTaskToUser(this.testAddTask(), this.id).subscribe(
        (response: whatTask) => {
          console.log(response);
          this.user_tasks.push(response);
        },
        (error: HttpErrorResponse) => {
          alert(error.error.message)
        }
      );
      this.selectedTask = true;
      document.getElementById('add-user-form')?.click();
    }
  }
  public deleteTaskFromUser(taskId: any): void{
    this.whatObjectiveService.deleteTaskFromUser(this.user_tasks[taskId].taskId, this.id).subscribe(
      (response: any) => {
      },
      (error: HttpErrorResponse) => {
        alert(error.error.message)
      }
    );
    this.user_tasks.splice(taskId, 1);
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
