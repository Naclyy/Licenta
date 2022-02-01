import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginApiService } from '../services/login-api.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  username:string;
  password:string;
  message:any

  constructor(private service:LoginApiService, private router:Router) { 
    this.username = ""
    this.password = ""
  }

  ngOnInit(): void {
  }

  doLogin(){
    let response = this.service.login(this.username, this.password);
    response.subscribe(data=>{
      this.message = data;
    this.router.navigate(["/home"])
    })
  }

}
