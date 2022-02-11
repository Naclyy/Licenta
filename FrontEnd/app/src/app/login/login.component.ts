import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../user';
import { NgForm } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private userService: UserService, private router: Router){}

  ngOnInit(): void {
  }

  public onAddUser(addForm: NgForm): void{
    this.userService.addUsers(addForm.value).subscribe(
      (response: User) => {
        console.log(response);
      },
      (error: HttpErrorResponse) => {
        alert(error.error.message)
      }
    );
    document.getElementById('add-user-form')?.click();
  }

  public onTestUser(testForm: NgForm): void{
    this.userService.testUsers(testForm.value).subscribe(
      (response: User) => {
        console.log("merge");
        this.router.navigate(['/home'])
      },
      (error: HttpErrorResponse) => {
        alert(error.error.message)
      }
    );
  }

  public onOpenModal(): void {

    const container = document.getElementById('main-container');
    const button = document.createElement('button');

    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-bs-toggle', 'modal');
    button.setAttribute('data-bs-target', '#addUserModal');
    container?.appendChild(button);
    button.click();

  }
}
