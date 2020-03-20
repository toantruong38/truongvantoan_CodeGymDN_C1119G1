import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-rating-bar",
  templateUrl: "./rating-bar.component.html",
  styleUrls: ["./rating-bar.component.css"]
})
export class RatingBarComponent implements OnInit {
  stars = [];
  isLocked = false;
  currentStarIndex: number;
  constructor() {}

  ngOnInit(): void {
    for (let i = 0; i < 10; i++) {
      let star = new Star();
      this.stars.push(star);
    }
  }

  handleMouseOver(index) {
    if (!this.isLocked) {
      for (let i = 0; i <= index; i++) {
        this.stars[i].isHovered = true;
      }
      this.currentStarIndex = index;
    }
  }
  handleMouseLeave() {
    if (!this.isLocked) {
      this.stars.map((value, index) => {
        value.isHovered = false;
      });
    }
  }
  handleMouseClicked() {
    this.isLocked = !this.isLocked;
  }
}
class Star {
  isHovered: boolean;

  constructor() {
    this.isHovered = false;
  }
}
