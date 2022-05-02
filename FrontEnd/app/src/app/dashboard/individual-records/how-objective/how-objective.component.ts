import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HowObjectiveService } from 'src/app/services/howObjective.service';
import { HttpErrorResponse } from '@angular/common/http';
import { howTask } from 'src/app/modules/howTask';
import {Form, FormBuilder, FormGroup, NgForm} from '@angular/forms';
import { ViewEncapsulation } from '@angular/core';
import { whatTask } from 'src/app/modules/whatTask';
import { WhatObjectiveService } from 'src/app/services/whatObjective.service';
import { IDropdownSettings, NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';

@Component({
  selector: 'app-how-objective',
  templateUrl: './how-objective.component.html',
  styleUrls: ['./how-objective.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class HowObjectiveComponent implements OnInit {
  public id : any
  public tasks: howTask[] = []
  public whatTasks: whatTask[] = []
  public dropdownSettings: IDropdownSettings = {};
  public howTasks: howTask[] = []
  public selectedItems: howTask[] = []
  dropDownForm: FormGroup;
  public taskId!: number;
  constructor(private whatObjectiveService: WhatObjectiveService,private howObjectiveService: HowObjectiveService,
     private router: Router, private _Activatedroute: ActivatedRoute, private fb: FormBuilder) { 
      this.dropDownForm = this.fb.group({
        myItems: []
      })
  }
  ngOnInit(): void {
    this.id = this._Activatedroute.snapshot.paramMap.get("id");
    this.getTasks(this.id)
    this.dropdownSettings = {
      idField: 'taskId',
      textField: 'objectives',
      noDataAvailablePlaceholderText: "There is no item availabale to show"
    };
    
  }
  public getTasks(userId: any): void{
    this.howObjectiveService.getTasks(userId).subscribe((response: any[]) => {
      console.log(response)
      this.tasks = response;
    }),(error: HttpErrorResponse) => {
      alert(error.message);
    };

    this.whatObjectiveService.getAllTasks().subscribe((response: whatTask[]) => {
      console.log(response)
      this.whatTasks = response;
      this.getHowTasksByWhatId(this.whatTasks[0].taskId)
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
  public getHowTasksByWhatId(taskId: number){
    this.howObjectiveService.getAllTasksForWhatId(taskId).subscribe((response: howTask[]) => {
      console.log(response)
      this.howTasks = response;
    },(error: HttpErrorResponse) => {
      alert(error.message);
    });
    this.taskId = taskId;
  }
  public onSelectChange(event:any){
    console.log(event.target.value)
    this.getHowTasksByWhatId(event.target.value)
    this.dropDownForm.reset();
    this.selectedItems = [];
  }
  onItemSelect(item: any) {
    this.selectedItems.push(item);
}
onItemDeSelect(item: any) {
    const index:number = this.selectedItems.indexOf(item);
    if (index !== -1) {
      this.selectedItems.splice(index, 1);
    }
}
onDeSelectAll(items: any){
  console.log(items); // items is an empty array

}
  resetForm(addForm: NgForm){
    this.selectedItems = [];
    addForm.resetForm();
    this.dropDownForm.reset();
  }
  public onAddHowTask(addForm: NgForm): void{
    this.howObjectiveService.addTask(addForm.value, this.id, this.taskId).subscribe(
      (response: howTask) => {
        console.log(response.taskId);
        this.tasks.push(response);
      },
      (error: HttpErrorResponse) => {
        alert(error.error.message)
      }
    );
    this.addPredecessor();
    this.resetForm(addForm);
    document.getElementById('add-user-form')?.click();
  }
  public addPredecessor(): void{
    for(let i = 0; i < this.selectedItems.length; i++){
      console.log(this.selectedItems[i].taskId)
      this.howObjectiveService.addPredecessor(this.selectedItems[i].taskId)
    }
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
