import { NgModule } from "@angular/core";
import { Routes, RouterModule} from '@angular/router';
import { DashboardComponent } from "./dashboard.component";
import { HomeComponent } from "./home/home.component";
import { SummaryComponent } from "./summary/summary.component";

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
            }

        ]
    }
];


@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class DashboardRoutingModule{}