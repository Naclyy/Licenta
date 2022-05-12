import { Component, OnInit } from '@angular/core';
import { User } from '../../modules/user';
import { UserService } from '../../user.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-team-members',
  templateUrl: './team-members.component.html',
  styleUrls: ['./team-members.component.css']
})
export class TeamMembersComponent implements OnInit {
  public users: User[] = [];
  public editedUserId = -1; 
  constructor(private userService: UserService, private router:Router, private loginService: LoginService) {
   }

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
  public deleteUser(userId : any): void{
    this.userService.deleteUsers(this.users[userId].userId);
    this.users.splice(userId, 1);
  }

  public onOpenModal(userId : any): void {
    this.editedUserId = userId;
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-bs-toggle', 'modal');
    button.setAttribute('data-bs-target', '#editUserModal');
    container?.appendChild(button);
    button.click();
  }

  public editUser(userId: number, addForm: NgForm): void{
    this.userService.updateUsers(userId,addForm.value).subscribe(
      (response: User) => {
        this.users[this.editedUserId] = response;
        console.log(response);
      },
      (error: HttpErrorResponse) => {
        alert(error.error.message)
      }
    );
    document.getElementById('add-user-form')?.click();
  }

  public onAddModal(): void {

    const container = document.getElementById('main-container');
    const button = document.createElement('button');

    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-bs-toggle', 'modal');
    button.setAttribute('data-bs-target', '#addUserModal');
    container?.appendChild(button);
    button.click();
  }


  public onAddUser(addForm: NgForm): void{
    this.loginService.addUsers(addForm.value).subscribe(
      (response: User) => {
        console.log(response);
      },
      (error: HttpErrorResponse) => {
        alert(error.error.message)
      }
    );
    document.getElementById('add-user-form')?.click();
  }
}
