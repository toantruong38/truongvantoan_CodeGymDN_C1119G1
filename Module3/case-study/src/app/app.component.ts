import { Component } from "@angular/core";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"],
})
export class AppComponent {
  title = "case-study";
  employeeData = {
    header: ["name", "address", "age"],
    data: [
      { name: "Elliott", address: "WST", age: 29 },
      { name: "Elliott", address: "WST", age: 29 },
      { name: "Elliott", address: "WST", age: 29 },
    ],
  };
}
