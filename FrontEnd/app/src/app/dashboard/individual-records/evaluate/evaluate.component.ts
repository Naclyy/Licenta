import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { Skills } from 'src/app/modules/skills';
import { SkillsService } from 'src/app/services/skills.service';
import { KeyStrengthService } from 'src/app/services/keyStrength.service';
import { Strength } from 'src/app/modules/strength';
@Component({
  selector: 'app-evaluate',
  templateUrl: './evaluate.component.html',
  styleUrls: ['./evaluate.component.css']
})
export class EvaluateComponent implements OnInit {
  public id : any;
  public skills: Skills[] = [];
  public strengths: Strength[] = [];
  constructor(private router: Router, private _Activatedroute: ActivatedRoute, private keyStrengthsService: KeyStrengthService
    , private skillsService: SkillsService) { 
  
  }

  ngOnInit(): void {
    this.id = this._Activatedroute.snapshot.paramMap.get("id");
    this.getSkills();
    this.getKeyStrengths();
  }
  public getSkills(): void{
    this.skillsService.getSkills().subscribe((response: Skills[]) => {
      console.log(response)
      this.skills = response;
    }),(error: HttpErrorResponse) => {
      alert(error.message);
    };
  }

  public getKeyStrengths(): void{
    this.keyStrengthsService.getKeyStrengths().subscribe((response: Strength[]) => {
      this.strengths = response;
      console.log(this.strengths )
    }),(error: HttpErrorResponse) => {
      alert(error.message);
    };
  }
  back(): void{
    this.router.navigate(["dashboard/individual-records"]);
  }
  howObjective(): void{
    this.router.navigate(["dashboard/individual-records/how-objective", this.id]);
  }
  whatObjective(): void{
    this.router.navigate(["dashboard/individual-records/what-objective", this.id]);
  }
}
