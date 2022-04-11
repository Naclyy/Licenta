import { NgModule } from "@angular/core";
import { Routes, RouterModule} from '@angular/router';
import { DashboardComponent } from "./dashboard.component";
import { HomeComponent } from "./home/home.component";
import { IndividualRecordsComponent } from "./individual-records/individual-records.component";
import { SummaryComponent } from "./summary/summary.component";
import { TeamMembersComponent } from "./team-members/team-members.component";
import { GraphComponent } from "./graph/graph.component";
const routes: Routes = [
    {
        path: '',
        component: DashboardComponent,
        children: [
            {
                path: 'home',
                component: HomeComponent
            },
            {
                path: '',
                redirectTo: 'home',
                pathMatch: 'full'
            },
            {
                path:'summary',
                component: SummaryComponent
            },
            {
                path:'team',
                component: TeamMembersComponent
            },
            {
                path:'graph',
                component: GraphComponent
            },
            {
                path:'individual-records',
                loadChildren: () => import("../dashboard/individual-records/individual-records.module").then(module => module.IndividualRecordsModule)
            }

        ]
    }
];


@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class DashboardRoutingModule{}