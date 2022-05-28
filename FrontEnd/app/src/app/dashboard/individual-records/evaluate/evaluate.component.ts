import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { Skills } from 'src/app/modules/skills';
import { SkillsService } from 'src/app/services/skills.service';
import { KeyStrengthService } from 'src/app/services/keyStrength.service';
import { Strength } from 'src/app/modules/strength';
import { UserService } from 'src/app/user.service';
import { User } from 'src/app/modules/user';
import jspdf from 'jspdf';
import { ElementRef } from '@angular/core';
import html2canvas from 'html2canvas';
@Component({
  selector: 'app-evaluate',
  templateUrl: './evaluate.component.html',
  styleUrls: ['./evaluate.component.css']
})
export class EvaluateComponent implements OnInit {
  public id : any;
  public skills: Skills[] = [];
  public strengths: Strength[] = [];
  public firstName: String = "";
  public lastName: String = "";
  constructor(private router: Router, private _Activatedroute: ActivatedRoute, private keyStrengthsService: KeyStrengthService
    , private skillsService: SkillsService, private userService: UserService) { 
  
  }

  ngOnInit(): void {
    this.id = this._Activatedroute.snapshot.paramMap.get("id");
    this.getSkills();
    this.getKeyStrengths();
    this.getName();
  }
  public getSkills(): void{
    this.skillsService.getSkills().subscribe((response: Skills[]) => {
      console.log(response)
      this.skills = response;
    }),(error: HttpErrorResponse) => {
      alert(error.message);
    };
  }

  public getName():void{
    this.userService.findUSerById(this.id).subscribe((response: User) => {
      console.log(response)
      this.firstName = response.firstName
      this.lastName = response.lastName
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
  public SavePDF(data : any): void {  
    html2canvas(data, { allowTaint: true }).then(canvas => {
      let HTML_Width = canvas.width;
      let HTML_Height = canvas.height;
      let top_left_margin = 10;
      let PDF_Width = HTML_Width + (top_left_margin * 2);
      let PDF_Height = (PDF_Width * 1.5) + (top_left_margin * 2);
      let canvas_image_width = HTML_Width;
      let canvas_image_height = HTML_Height;
      let totalPDFPages = Math.ceil(HTML_Height / PDF_Height) - 1;
      canvas.getContext('2d');
      let imgData = canvas.toDataURL("image/jpeg", 1.0);
      let pdf = new jspdf('p', 'pt', [PDF_Width, PDF_Height]);
      pdf.addImage(imgData, 'JPG', top_left_margin, top_left_margin, canvas_image_width, canvas_image_height);
      for (let i = 1; i <= totalPDFPages; i++) {
        pdf.addPage([PDF_Width, PDF_Height], 'p');
        pdf.addImage(imgData, 'JPG', top_left_margin, -(PDF_Height * i) + (top_left_margin * 4), canvas_image_width, canvas_image_height);
      }
       pdf.save("EvaluateForm.pdf");
    }); 
  }  
}
