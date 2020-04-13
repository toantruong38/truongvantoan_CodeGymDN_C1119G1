import { NewClientFormComponent } from "./_forms/new-client-form/new-client-form.component";
import { ContractComponent } from "./contract/contract.component";
import { EmployeeComponent } from "./employee/employee.component";
import { DashBoardComponent } from "./dash-board/dash-board.component";
import { ClientComponent } from "./client/client.component";
import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";

const routes: Routes = [
  {
    path: "clients/new",
    component: NewClientFormComponent,
  },
  { path: "clients/:id", component: NewClientFormComponent },
  {
    path: "clients",
    component: ClientComponent,
  },
  { path: "employees", component: EmployeeComponent },
  { path: "contracts", component: ContractComponent },
  { path: "", component: DashBoardComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
