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
  public allUsers: User[] = [];
  public selectedUsers: User[] = [];
  public editedUserId = -1;
  public pageNumbers: String[] = [];
  public numberOfPages: number = 1;
  public currentPage:String = "1";
  constructor(private userService: UserService, private router:Router, private loginService: LoginService) {
   }

  ngOnInit(): void {
    this.getAllUsers();
  }
  back_home(): void{
    this.router.navigate(["dashboard/home"]);
  }
  public getAllUsers(): void{
    console.log(localStorage.getItem('token'))
    this.userService.getUsers().subscribe((response: User[]) => {
      this.allUsers = response;
      this.numberOfPages = Math.ceil(this.allUsers.length/5)
      for(let i = 1; i <= this.numberOfPages; i++)
        this.pageNumbers.push(i.toString());
      for(let i = 0; i < 5; i++)
        this.selectedUsers.push(this.allUsers[i])
    }),(error: HttpErrorResponse) => {
      alert(error.message);
    };
  }

  public deleteUser(userId : any, id:number): void{
    this.userService.deleteUsers(userId);
    for(let i = 0;i < this.allUsers.length; i++)
      if(this.allUsers[i] == this.selectedUsers[id])
        this.allUsers.splice(i, 1);
    this.selectedUsers.splice(id, 1);
    this.selectedUsers.push(this.allUsers[Number(this.currentPage) * 5 - 1])
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
        this.allUsers[this.editedUserId] = response;
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

  public routeToProfile(id: number): void{
    this.router.navigate(["dashboard/profile", id]);
  }

  public onAddUser(addForm: NgForm): void{
    this.loginService.addUsers(addForm.value).subscribe(
      (response: User) => {
        console.log(response)
        if(this.selectedUsers.length != 5){
          this.selectedUsers.push(response)
          this.pageNumbers.push((this.numberOfPages + 1).toString())
        }
        this.allUsers.push(response)
      },
      (error: HttpErrorResponse) => {
        alert(error.error.message)
      }
    );
    document.getElementById('add-user-form')?.click();
  }
  public changePage(pageNumber: number):void{
    this.selectedUsers = [];
    console.log(this.numberOfPages)
    console.log(pageNumber)
    if(pageNumber == this.numberOfPages)
    {
      for(let i = 5*(pageNumber-1); i < this.allUsers.length; i++)
        this.selectedUsers.push(this.allUsers[i])
        this.currentPage = pageNumber.toString();
    }
    else{
      for(let i = 5*(pageNumber-1); i < 5*(pageNumber-1) + 5; i++)
        this.selectedUsers.push(this.allUsers[i])
        this.currentPage = pageNumber.toString();
    }
  }
}
