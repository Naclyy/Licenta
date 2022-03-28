import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/user.service';
import { Router } from '@angular/router';
import { User } from 'src/app/modules/user';
import { HttpErrorResponse } from '@angular/common/http';
@Component({
  selector: 'app-select-user',
  templateUrl: './select-user.component.html',
  styleUrls: ['./select-user.component.css']
})
export class SelectUserComponent implements OnInit {
  public users: User[] = []
  public selectedUser = false;
  constructor(private userService: UserService, private router: Router) { }
  
  ngOnInit(): void {
    this.getUsers();
  }
  openDropDown():void {
    const optionsContainer = <HTMLVideoElement>document.querySelector(".options-container")
    optionsContainer.classList.toggle("active");
  }
  selectUser(user_email: any):void {
    const optionsContainer = <HTMLVideoElement>document.querySelector(".options-container")
    const selected = <HTMLVideoElement>document.querySelector(".selected");
    selected.innerHTML = user_email;
    optionsContainer.classList.remove("active");
    this.selectedUser = true;
  }

  isUserChoosen(): Number{
    if(this.selectedUser == false)
      return -1;
    const selected = <HTMLVideoElement>document.querySelector(".selected");
    const choosen_email = selected.innerHTML;
    for(let i = 0; i < this.users.length; i++)
      if(this.users[i].email == choosen_email)
        return this.users[i].userId
    return -1
  }

  howObjective(): void{
    const user_id = this.isUserChoosen()
    if(user_id == -1)
      console.log("not selected");
    else
      this.router.navigate(["dashboard/individual-records/how-objective", user_id]);
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
