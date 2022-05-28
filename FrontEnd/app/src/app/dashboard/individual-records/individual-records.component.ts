import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-individual-records',
  templateUrl: './individual-records.component.html',
  styleUrls: ['./individual-records.component.css']
})
export class IndividualRecordsComponent implements OnInit {
  constructor(private router: Router) { }
  ngOnInit(): void {
  }
  back_home(): void{
    this.router.navigate(["dashboard/home"]);
  }
}
