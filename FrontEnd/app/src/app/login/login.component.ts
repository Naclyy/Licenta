import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../modules/user';
import { Login } from "../modules/login";
import { NgForm } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private userService: UserService, private loginService: LoginService, private router: Router){}

  ngOnInit(): void {
  }


  public onTestUser(testForm: NgForm): void{
    this.loginService.testUsers(testForm.value).subscribe(
      (response: any) => {
        this.router.navigate(["dashboard"]).then();
      },
      (error: HttpErrorResponse) => {
        alert(error.error.message)
      }
    );
  }

}
