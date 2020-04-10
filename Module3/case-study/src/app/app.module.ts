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
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
