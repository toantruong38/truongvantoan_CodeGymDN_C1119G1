import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-color-picker",
  templateUrl: "./color-picker.component.html",
  styleUrls: ["./color-picker.component.css"]
})
export class ColorPickerComponent implements OnInit {
  bgColor: string;
  isSelected = false;
  colors = [
    "#ff0000",
    "#ff4000",
    "#ff8000",
    "#ffbf00",
    "#ffff00",
    "#bfff00",
    "#80ff00",
    "#40ff00",
    "#ff0040",
    "#ff00bf",
    "#bf00ff",
    "#8000ff",
    "#4000ff",
    "#0080ff"
  ];
  constructor() {}

  ngOnInit(): void {}

  handleClick(value) {
    this.bgColor = value;
  }
}
