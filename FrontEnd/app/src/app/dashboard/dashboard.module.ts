import { NgModule } from '@angular/core';
import { HomeComponent } from './home/home.component';
import { DashboardComponent } from './dashboard.component';
import { SummaryComponent } from './summary/summary.component';
import { FormsModule } from '@angular/forms';
import { DashboardRoutingModule } from './dashboard-routing.module';
import { CommonModule } from "@angular/common";
import { HeaderComponent } from './header/header.component';
import { TeamMembersComponent } from './team-members/team-members.component';
import { IndividualRecordsComponent } from './individual-records/individual-records.component';
import { GraphComponent } from './graph/graph.component';
import { NgChartsModule } from 'ng2-charts';
import { GanttChartAngularModule } from 'gantt-chart-angular';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { ControlObjectiveComponent } from './control-objective/control-objective.component';
@NgModule({
  declarations: [
    HomeComponent,
    SummaryComponent,
    DashboardComponent,
    HeaderComponent,
    TeamMembersComponent,
    IndividualRecordsComponent,
    GraphComponent,
    UserProfileComponent,
    ControlObjectiveComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    DashboardRoutingModule,
    NgChartsModule,
    GanttChartAngularModule
  ],
})
export class DashboardModule { }
