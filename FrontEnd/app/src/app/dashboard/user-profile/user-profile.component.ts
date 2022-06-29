import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/modules/user';
import { UserService } from 'src/app/user.service';
import { HowObjectiveService } from 'src/app/services/howObjective.service'
import { howTask } from 'src/app/modules/howTask';
@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  public id: any
  public user!: User;
  public tasks: howTask[] = [];
  constructor(private howObjectiveService: HowObjectiveService ,private router: Router, private _Activatedroute: ActivatedRoute, private userService: UserService) { }

  ngOnInit(): void {
    this.id = this._Activatedroute.snapshot.paramMap.get("id");
    this.getUserInfo();
  }
  back_home(): void{
    this.router.navigate(["dashboard/team"]);
  }
  public getUserInfo():void{
    this.userService.findUSerById(this.id).subscribe((response: User) => {
      this.user = response;
    }),(error: HttpErrorResponse) => {
      alert(error.message);
    };
    this.howObjectiveService.getTasks(this.id).subscribe((response: any[]) => {
      this.tasks = response;
    }),(error: HttpErrorResponse) => {
      alert(error.message);
    };
  }
}
