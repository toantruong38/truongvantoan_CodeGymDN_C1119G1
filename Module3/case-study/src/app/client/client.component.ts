import { TableService } from "./../_services/table-service/table.service";
import { TableInfo } from "./../_models/table-info";
import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-client",
  templateUrl: "./client.component.html",
  styleUrls: ["./client.component.css"],
})
export class ClientComponent implements OnInit {
  tableInfo: TableInfo;
  tableData: Object[];

  constructor(private tableService: TableService) {
    this.tableService.sharedTableData$.subscribe((tableInfo) => {
      this.tableInfo = tableInfo;
      this.tableInfo.actionUrl = "/clients";
    });
  }

  ngOnInit(): void {}
}
