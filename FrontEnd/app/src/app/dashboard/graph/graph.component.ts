import { Component, OnInit } from '@angular/core';
import { EstimateGraph } from 'src/app/modules/estimateGraph';
import { EstimateGraphService } from 'src/app/services/estimateGraph.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';
@Component({
  selector: 'app-graph',
  templateUrl: './graph.component.html',
  styleUrls: ['./graph.component.css']
})
export class GraphComponent implements OnInit {
  public graphElements: EstimateGraph[] = [];
  public barChartLabels: string[] = [];
  public earlyStartData: number[] = [];
  public earlyFinishData: number[] = [];
  public lateStartData: number[] = [];
  public lateFinishData: number[] = [];
  public estimated_days: number = 0;
  constructor(private graphService: EstimateGraphService, private router:Router) { }

  public barChartOptions: any = {
    scaleShowVerticalLines: false,
    responsive: true
  };
  
  public barChartType: string = 'bar';
  public barChartLegend: boolean = true;

  public barChartData: any[] = [];
  public getGraph(): void{
    this.graphService.getGraphEstimation().subscribe((res) => {
      this.graphElements = res;
      for(let i = 0; i < this.graphElements.length; i++)
      {
        if(this.estimated_days < this.graphElements[i].lateFinish)
          this.estimated_days = this.graphElements[i].lateFinish;
      this.barChartLabels.push(this.graphElements[i].name)
      this.earlyStartData.push(this.graphElements[i].earlyStart)
      this.earlyFinishData.push(this.graphElements[i].earlyFinish)
      this.lateStartData.push(this.graphElements[i].lateStart)
      this.lateFinishData.push(this.graphElements[i].lateFinish)
      }
      this.barChartData=[ 
        { data: this.earlyStartData, label: 'Early Start' },
        { data: this.earlyFinishData, label: 'Early Finish' },
        { data: this.lateStartData, label: 'Late Start' },
        { data: this.lateFinishData, label: 'Late Finish', backgroundColor: "red"}
      ]
    }),(error: HttpErrorResponse) => {
      alert(error.message);
    };
    
  }

  back(): void{
    this.router.navigate(["dashboard/home"]);
  }
 
  ngOnInit() {
    this.getGraph();
    
  }

}
