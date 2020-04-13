import { TableService } from "./../_services/table-service/table.service";
import { TableInfo } from "./../_models/table-info";
import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-detailed-contract",
  templateUrl: "./detailed-contract.component.html",
  styleUrls: ["./detailed-contract.component.css"],
})
export class DetailedContractComponent implements OnInit {
  tableInfo: TableInfo;
  tableData: Object[];

  constructor(private tableService: TableService) {
    this.tableService.sharedTableData$.subscribe((tableInfo) => {
      this.tableInfo = tableInfo;
      this.tableInfo.actionUrl = "/detailed-contracts";
    });
  }

  ngOnInit(): void {}
}
