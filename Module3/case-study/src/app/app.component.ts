import { NewClientFormComponent } from "./_forms/new-client-form/new-client-form.component";
import { EditService } from "./_services/edit-service/edit.service";
import { ContractComponent } from "./contract/contract.component";
import { ServiceComponent } from "./service/service.component";
import { EmployeeComponent } from "./employee/employee.component";
import { DashboardService } from "./_services/dashboard-service/dashboard.service";
import { DashBoardComponent } from "./dash-board/dash-board.component";
import { ClientComponent } from "./client/client.component";
import { TableService } from "./_services/table-service/table.service";
import { TableInfo } from "./_models/table-info";
import { DataServiceService } from "./_services/data-service.service";
import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"],
})
export class AppComponent implements OnInit {
  title = "case-study";
  clientData = new TableInfo();
  employeeData = new TableInfo();
  contractData = new TableInfo();
  serviceData = new TableInfo();
  constructor(
    private dataService: DataServiceService,
    private tableService: TableService,
    private dashboardService: DashboardService,
    private editService: EditService
  ) {}
  ngOnInit() {
    this.prepareClientData();
    this.prepareEmployeeData();
    this.prepareContractData();
    this.prepareServiceData();
  }

  prepareClientData() {
    this.dataService.getData("clients").subscribe((data: Object[]) => {
      this.clientData.data = data;
    });
    this.clientData.header = [
      "Ma khach hang",
      "Ho ten",
      "Ngay sinh",
      "Gioi tinh",
      "Email",
      "So dien thoai",
      "Chung minh",
      "Dia chi",
      "#id",
    ];
  }
  prepareEmployeeData() {
    this.dataService.getData("employees").subscribe((data: Object[]) => {
      this.employeeData.data = data;
    });
    this.employeeData.header = [
      "Ho ten",
      "Ma nhan vien",
      "Dia chi",
      "Ngay sinh",
      "Email",
      "Chung minh nhan dan",
      "So dien thoai",
      "Luong",
      "#id",
    ];
  }
  prepareContractData() {
    this.dataService.getData("contracts").subscribe((data: Object[]) => {
      this.contractData.data = data;
    });
    this.contractData.header = [
      "Ngay bat dau",
      "Ngay ket thuc",
      "So hop dong",
      "Tien dat coc",
      "Tong",
      "#id",
    ];
  }
  prepareServiceData() {
    this.dataService.getData("services").subscribe((data: Object[]) => {
      this.serviceData.data = data;
    });
    this.serviceData.header = [
      "Dien tich",
      "So tang",
      "Dich vu mien phi di kem",
      "So nguoi toi da",
      "Mo ta",
      "Chi phi thue",
      "Trang thai",
      "Tieu chuan phong",
      "#id",
    ];
  }

  onOutletLoaded(component) {
    if (component instanceof ClientComponent) {
      this.tableService.transferData(this.clientData);
    } else if (component instanceof DashBoardComponent) {
      this.dashboardService.transfer({
        clientData: this.clientData,
        employeeData: this.employeeData,
        contractData: this.contractData,
        serviceData: this.serviceData,
      });
    } else if (component instanceof EmployeeComponent) {
      this.tableService.transferData(this.employeeData);
    } else if (component instanceof ServiceComponent) {
      this.tableService.transferData(this.serviceData);
    } else if (component instanceof ContractComponent) {
      this.tableService.transferData(this.contractData);
    } else if (component instanceof NewClientFormComponent) {
      this.editService.transfer(this.clientData.data);
    }
    // else if (component instanceof ) {
    //   this.tableService.transferData(this.clientData);
    // }
  }
}
