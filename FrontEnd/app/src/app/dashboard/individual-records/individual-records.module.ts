import { NgModule } from '@angular/core';
import { CommonModule } from "@angular/common";
import { FormsModule } from '@angular/forms';
import { IndividualRecordsRoutingModule } from './individual-records-routing.module';
import { SelectUserComponent } from './select-user/select-user.component';
import { HowObjectiveComponent } from './how-objective/how-objective.component';
import { WhatObjectiveComponent } from './what-objective/what-objective.component';
import { EvaluateComponent } from './evaluate/evaluate.component';
import { MatSliderModule } from '@angular/material/slider';
import {MatInputModule} from '@angular/material/input';
import {MatSelectModule} from '@angular/material/select';
import { NgMultiSelectDropDownModule} from 'ng-multiselect-dropdown'; 
import {ReactiveFormsModule } from '@angular/forms';
@NgModule({
  declarations: [
  
    SelectUserComponent,
       HowObjectiveComponent,
       WhatObjectiveComponent,
       EvaluateComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    IndividualRecordsRoutingModule,
    MatSliderModule,
    MatInputModule,
    MatSelectModule,
    NgMultiSelectDropDownModule,
    ReactiveFormsModule
  ],
})
export class IndividualRecordsModule { }
