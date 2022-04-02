import { NgModule } from "@angular/core";
import { Routes, RouterModule} from '@angular/router';
import { HowObjectiveComponent } from "./how-objective/how-objective.component";
import { IndividualRecordsComponent } from "./individual-records.component";
import { SelectUserComponent } from "./select-user/select-user.component";
import { WhatObjectiveComponent } from "./what-objective/what-objective.component";
import { EvaluateComponent } from "./evaluate/evaluate.component";
const routes: Routes = [
    {
        path: '',
        component: IndividualRecordsComponent,
        children: [
            {
                path: 'select-user',
                component: SelectUserComponent
            },
            {
                path: '',
                redirectTo: 'select-user',
                pathMatch: 'full'
            },
            {
                path:'how-objective/:id',
                component: HowObjectiveComponent
            },
            {
                path:'what-objective/:id',
                component: WhatObjectiveComponent
            },
            {
                path:'evaluate/:id',
                component: EvaluateComponent
            }
        ]
    }
];


@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class IndividualRecordsRoutingModule{}