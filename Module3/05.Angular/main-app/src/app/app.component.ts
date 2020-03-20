import { OnInit } from "@angular/core";
import { Component } from "@angular/core";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"]
})
export class AppComponent implements OnInit {
  ngOnInit(): void {
    this.progressValue = 80;
  }
  title = "main-app";
  progressValue = 0;
  progressCursor = 0;
  maximumProgressCursor = 10000;
  runProgress() {
    setTimeout(() => {
      while (true) {
        this.progressValue = this.progressCursor / 100;
        this.progressCursor === this.maximumProgressCursor
          ? (this.progressCursor = 0)
          : this.progressCursor++;
      }
    }, 800);
  }
}
