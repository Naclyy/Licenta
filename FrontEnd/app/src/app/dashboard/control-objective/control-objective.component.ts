import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { whatTask } from 'src/app/modules/whatTask';
import { WhatObjectiveService } from 'src/app/services/whatObjective.service';

@Component({
  selector: 'app-control-objective',
  templateUrl: './control-objective.component.html',
  styleUrls: ['./control-objective.component.css']
})
export class ControlObjectiveComponent implements OnInit {

  public what_tasks: whatTask[] = []
  constructor(private whatObjectiveService: WhatObjectiveService, private router: Router) { 
  }
  ngOnInit(): void {
    this.getTasks()
  }
  public getTasks(): void{
    this.whatObjectiveService.getAllTasks().subscribe((response: whatTask[]) => {
      this.what_tasks = response;
    }),(error: HttpErrorResponse) => {
      alert(error.message);
    };
  }
  back(): void{
    this.router.navigate(["dashboard/home"]);
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
  public onAddWhatTask(form: NgForm): void{
      this.whatObjectiveService.addTask(form.value).subscribe((response: whatTask) => {
        this.what_tasks.push(response)
      }),(error: HttpErrorResponse) => {
        alert(error.message);
      };

      document.getElementById('add-user-form')?.click();
  }
  public deleteTask(id: number ) : void{
    this.whatObjectiveService.deleteTask(this.what_tasks[id].taskId);
    this.what_tasks.splice(id, 1);
  }
}
