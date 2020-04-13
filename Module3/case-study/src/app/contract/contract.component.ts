import { TableService } from "./../_services/table-service/table.service";
import { TableInfo } from "./../_models/table-info";
import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-contract",
  templateUrl: "./contract.component.html",
  styleUrls: ["./contract.component.css"],
})
export class ContractComponent implements OnInit {
  tableInfo: TableInfo;
  tableData: Object[];

  constructor(private tableService: TableService) {
    this.tableService.sharedTableData$.subscribe((tableInfo) => {
      this.tableInfo = tableInfo;
      this.tableInfo.actionUrl = "/contracts";
    });
  }

  ngOnInit(): void {}
}
