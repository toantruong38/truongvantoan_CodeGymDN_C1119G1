import { TableService } from "./../_services/table-service/table.service";
import { TableInfo } from "./../_models/table-info";
import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-employee",
  templateUrl: "./employee.component.html",
  styleUrls: ["./employee.component.css"],
})
export class EmployeeComponent implements OnInit {
  tableInfo: TableInfo;
  tableData: Object[];

  constructor(private tableService: TableService) {
    this.tableService.sharedTableData$.subscribe((tableInfo) => {
      this.tableInfo = tableInfo;
      this.tableInfo.actionUrl = "/employees";
    });
  }

  ngOnInit(): void {}
}
