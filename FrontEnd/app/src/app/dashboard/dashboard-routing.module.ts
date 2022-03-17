import { NgModule } from "@angular/core";
import { Routes, RouterModule} from '@angular/router';
import { DashboardComponent } from "./dashboard.component";
import { HomeComponent } from "./home/home.component";
import { SummaryComponent } from "./summary/summary.component";
import { TeamMembersComponent } from "./team-members/team-members.component";
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
            }

        ]
    }
];


@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class DashboardRoutingModule{}