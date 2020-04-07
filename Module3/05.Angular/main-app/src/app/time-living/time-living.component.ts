import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-time-living",
  templateUrl: "./time-living.component.html",
  styleUrls: ["./time-living.component.css"],
})
export class TimeLivingComponent implements OnInit {
  result = "Oke,yo";
  constructor() {}

  ngOnInit(): void {}

  calculateMe(time: string) {
    this.result = "";
    try {
      let inputDate = new Date(time.split("-").reverse().join("-"));
      let currentDate = new Date();
      let ageInYear =
        (currentDate.getTime() - inputDate.getTime()) /
        (1000 * 3600 * 24 * 360);
      this.result += `${Math.floor(ageInYear)} nam `;
      ageInYear = ageInYear % 1;
      this.result +=
        ageInYear !== 0
          ? `${Math.floor((ageInYear = ageInYear * 12))} thang `
          : "";
      ageInYear = ageInYear % 1;
      this.result += `${Math.floor(ageInYear * 30)} ngay`;
    } catch (err) {
      this.result = "Not oke";
    }
  }
}
