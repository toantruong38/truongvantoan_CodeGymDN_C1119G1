import { TableService } from "./../_services/table-service/table.service";
import { TableInfo } from "./../_models/table-info";
import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-service",
  templateUrl: "./service.component.html",
  styleUrls: ["./service.component.css"],
})
export class ServiceComponent implements OnInit {
  tableInfo: TableInfo;
  tableData: Object[];

  constructor(private tableService: TableService) {
    this.tableService.sharedTableData$.subscribe((tableInfo) => {
      this.tableInfo = tableInfo;
      this.tableInfo.actionUrl = "/services";
    });
  }

  ngOnInit(): void {}
}
