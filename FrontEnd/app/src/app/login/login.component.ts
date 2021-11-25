import { Component, OnInit } from '@angular/core';
import { RestapiService } from '../restapi.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username:string;
  password:string;
  message:any

  constructor(private service:RestapiService) { 
    this.username = ""
    this.password = ""
  }

  ngOnInit(): void {
  }

  doLogin(){
    let response = this.service.login(this.username, this.password);
    response.subscribe(data=>{
      console.log(data)
    })
  }

}
