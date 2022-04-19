import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HowObjectiveService } from 'src/app/services/howObjective.service';
import { HttpErrorResponse } from '@angular/common/http';
import { howTask } from 'src/app/modules/howTask';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-how-objective',
  templateUrl: './how-objective.component.html',
  styleUrls: ['./how-objective.component.css']
})
export class HowObjectiveComponent implements OnInit {
  public id : any
  public tasks: howTask[] = []

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
  public onOpenModal(): void {

    const container = document.getElementById('main-container');
    const button = document.createElement('button');

    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-bs-toggle', 'modal');
    button.setAttribute('data-bs-target', '#addHowTaskModal');
    container?.appendChild(button);
    button.click();

  }
  public onAddHowTask(addForm: NgForm): void{
    // this.whatObjectiveService.addTask(addForm.value, this.id).subscribe(
    //   (response: whatTask) => {
    //     console.log(response);
    //     this.tasks.push(response);
    //   },
    //   (error: HttpErrorResponse) => {
    //     alert(error.error.message)
    //   }
    // );
    document.getElementById('add-user-form')?.click();
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
