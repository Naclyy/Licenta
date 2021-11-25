import { Component, OnInit } from '@angular/core';
import { RestapiService } from '../restapi.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  trainers:any;
  username:any;
  constructor(private service:RestapiService) { }

  ngOnInit(): void {
  }
  getTrainers(){
    let resp = this.service.getTrainers();
    resp.subscribe(data=>this.trainers = data);
  }

}
