import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../../modules/user';
import { UserService } from '../../user.service';
@Component({
  selector: 'app-summary',
  templateUrl: './summary.component.html',
  styleUrls: ['./summary.component.css']
})
export class SummaryComponent implements OnInit {
  public users: User[] = [];
  
  constructor(private userService: UserService, private router: Router){}
  
  ngOnInit(): void {
      this.getUsers();
  }
  back_home(): void{
    this.router.navigate(["dashboard/home"]);
  }
  public getUsers(): void{
    this.userService.getUsers().subscribe((response: User[]) => {
      this.users = response;
    }),(error: HttpErrorResponse) => {
      alert(error.message);
    };
  }
}
