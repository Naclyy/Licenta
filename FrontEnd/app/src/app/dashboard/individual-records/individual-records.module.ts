import { NgModule } from '@angular/core';
import { CommonModule } from "@angular/common";
import { FormsModule } from '@angular/forms';
import { IndividualRecordsRoutingModule } from './individual-records-routing.module';
import { SelectUserComponent } from './select-user/select-user.component';
import { HowObjectiveComponent } from './how-objective/how-objective.component';
import { WhatObjectiveComponent } from './what-objective/what-objective.component';

@NgModule({
  declarations: [
  
    SelectUserComponent,
       HowObjectiveComponent,
       WhatObjectiveComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    IndividualRecordsRoutingModule
  ],
})
export class IndividualRecordsModule { }