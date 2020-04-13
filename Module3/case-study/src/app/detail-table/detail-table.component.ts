import { TableService } from "./../_services/table-service/table.service";
import { Component, OnInit, Input } from "@angular/core";
import { TableInfo } from "../_models/table-info";
import * as $ from "jquery";

@Component({
  selector: "app-detail-table",
  templateUrl: "./detail-table.component.html",
  styleUrls: ["./detail-table.component.css"],
})
export class DetailTableComponent implements OnInit {
  @Input("tableInfo") tableInfo: TableInfo;
  objData: Array<any[]>;
  constructor() {}

  ngOnInit(): void {
    this.initiateData();

    $(document).ready(function () {
      $("#myInput").on("keyup", function () {
        var value = $(this).val().toLowerCase();
        $("#myTableBody tr").filter(function () {
          $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
        });
      });
    });
  }
  initiateData() {
    // if (!this.tableData) return;

    let propNames = Object.getOwnPropertyNames(this.tableInfo.data[0]);

    this.objData = this.tableInfo.data.map((obj) => {
      return propNames.map((prop) => obj[prop]);
    });
  }
}
