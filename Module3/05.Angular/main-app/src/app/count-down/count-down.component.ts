import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-count-down",
  templateUrl: "./count-down.component.html",
  styleUrls: ["./count-down.component.css"]
})
export class CountDownComponent implements OnInit {
  counter = 0;
  isRunning = false;
  constructor() {}

  ngOnInit(): void {}
  start() {
    this.isRunning = true;
    // while (this.isRunning && this.counter > 0) {
    //   setTimeout(() => {
    //     this.counter--;
    //   }, 1000);
    // }
    // for (let i = this.counter; i >= 0 && this.isRunning;){
    //   new Promise(() => {
    //     setTimeout()
    //   })
    //   console.log(i);
    // }
    new Promise(resolve => {
      setTimeout(() => {
        this.counter--;
        resolve();
      }, 1000);
    }).then(() => {
      if (this.isRunning && this.counter > 0) {
        console.log("callback");
        this.start();
      }
    });
  }
}
