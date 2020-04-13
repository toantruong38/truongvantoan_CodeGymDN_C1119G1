import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { NewClientFormComponent } from "./_forms/new-client-form/new-client-form.component";
import { InputFormatDirective } from "./_formatters/input_formatters/input-format.directive";
import { NewEmployeeFormComponent } from "./_forms/new-employee-form/new-employee-form.component";
import { NewServiceFormComponent } from "./_forms/new-service-form/new-service-form.component";
import { NewContractFormComponent } from "./_forms/new-contract-form/new-contract-form.component";
import { NavigationBarComponent } from "./navigation-bar/navigation-bar.component";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { LeftSideNavComponent } from "./left-side-nav/left-side-nav.component";
import { DashsboardCardComponent } from "./dashsboard-card/dashsboard-card.component";
import { DashboardTableComponent } from "./dashboard-table/dashboard-table.component";
import { CommonModule } from "@angular/common";
import { DetailTableComponent } from "./detail-table/detail-table.component";
import { ClientComponent } from "./client/client.component";
import { HttpClientModule } from "@angular/common/http";
import { DashBoardComponent } from './dash-board/dash-board.component';
import { EmployeeComponent } from './employee/employee.component';
import { ContractComponent } from './contract/contract.component';
import { ServiceComponent } from './service/service.component';
import { DetailedContractComponent } from './detailed-contract/detailed-contract.component';

@NgModule({
  declarations: [
    AppComponent,
    NewClientFormComponent,
    InputFormatDirective,
    NewEmployeeFormComponent,
    NewServiceFormComponent,
    NewContractFormComponent,
    NavigationBarComponent,
    LeftSideNavComponent,
    DashsboardCardComponent,
    DashboardTableComponent,
    DetailTableComponent,
    ClientComponent,
    DashBoardComponent,
    EmployeeComponent,
    ContractComponent,
    ServiceComponent,
    DetailedContractComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
