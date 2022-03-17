import { NgModule } from '@angular/core';
import { HomeComponent } from './home/home.component';
import { DashboardComponent } from './dashboard.component';
import { SummaryComponent } from './summary/summary.component';
import { FormsModule } from '@angular/forms';
import { DashboardRoutingModule } from './dashboard-routing.module';
import { CommonModule } from "@angular/common";
import { HeaderComponent } from './header/header.component';
import { TeamMembersComponent } from './team-members/team-members.component';
@NgModule({
  declarations: [
    HomeComponent,
    SummaryComponent,
    DashboardComponent,
    HeaderComponent,
    TeamMembersComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    DashboardRoutingModule
  ],
})
export class DashboardModule { }
