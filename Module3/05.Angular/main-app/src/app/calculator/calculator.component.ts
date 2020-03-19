import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-calculator",
  templateUrl: "./calculator.component.html",
  styleUrls: ["./calculator.component.css"]
})
export class CalculatorComponent implements OnInit {
  result = 0;
  constructor() {}

  ngOnInit(): void {}

  handleExecute(value1, value2, command) {
    value1 = Number.parseInt(value1);
    value2 = Number.parseInt(value2);
    switch (command) {
      case "+":
        this.result = value1 + value2;
        break;
      case "-":
        this.result = value1 - value2;
        break;
      case "/":
        this.result = value1 / value2;
        break;
      case "*":
        this.result = value1 * value2;
        break;
    }
  }
}
