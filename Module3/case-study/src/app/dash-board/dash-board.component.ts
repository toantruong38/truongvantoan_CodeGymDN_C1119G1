import { DashboardService } from "./../_services/dashboard-service/dashboard.service";
import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-dash-board",
  templateUrl: "./dash-board.component.html",
  styleUrls: ["./dash-board.component.css"],
})
export class DashBoardComponent implements OnInit {
  dashboardData: any;
  constructor(private dashboardService: DashboardService) {
    dashboardService.dashBoardData$.subscribe((data) => {
      this.dashboardData = data;
    });
  }

  ngOnInit(): void {}
}
