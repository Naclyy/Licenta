import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from './modules/user';
import { UserService } from './user.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  public users: User[] = [];

  constructor(private userService: UserService){}

  ngOnInit(): void {
      this.getUsers();
  }

  public getUsers(): void{
    this.userService.getUsers().subscribe((response: User[]) => {
      this.users = response;
    }),(error: HttpErrorResponse) => {
      alert(error.message);
    };
  }
}
