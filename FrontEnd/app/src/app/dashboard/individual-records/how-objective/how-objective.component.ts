import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-how-objective',
  templateUrl: './how-objective.component.html',
  styleUrls: ['./how-objective.component.css']
})
export class HowObjectiveComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }
  back_home(): void{
    this.router.navigate(["dashboard/home"]);
  }
}
