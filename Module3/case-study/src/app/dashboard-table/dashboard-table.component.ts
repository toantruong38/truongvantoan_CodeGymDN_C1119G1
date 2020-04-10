import { Input } from "@angular/core";
import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-dashboard-table",
  templateUrl: "./dashboard-table.component.html",
  styleUrls: ["./dashboard-table.component.css"],
})
export class DashboardTableComponent implements OnInit {
  @Input("tableHeader") tableHeader: string[];
  @Input("tableData") tableData: Object[];
  constructor() {}

  ngOnInit(): void {}

  get objData(): Array<any[]> {
    let propNames = Object.getOwnPropertyNames(this.tableData[0]);
    propNames.length > 5 ? (propNames.length = 5) : "";

    console.log(this.tableData);

    return;
  }
}
