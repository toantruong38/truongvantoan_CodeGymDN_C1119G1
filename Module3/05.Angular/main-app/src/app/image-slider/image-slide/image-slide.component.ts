import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-image-slide",
  templateUrl: "./image-slide.component.html",
  styleUrls: ["./image-slide.component.css"],
})
export class ImageSlideComponent implements OnInit {
  listImage = [
    "https://i.kym-cdn.com/photos/images/newsfeed/001/474/408/c00.jpg",
    "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTOGy6-bXPJjSgTMmHyivlYowPuL_16XP0md5luRIm0yRl_pbIw&usqp=CAU",
    "https://i.pinimg.com/originals/1e/d3/72/1ed372eb97c647ec644b98d6c5eb39d1.jpg",
    "https://banner2.cleanpng.com/20180521/jzj/kisspng-pepe-the-frog-screenshot-laptop-5b0253aa7d5255.9808098715268791465133.jpg",
  ];
  currentIndex = 0;
  constructor() {}

  ngOnInit(): void {}

  onNextImg() {
    this.currentIndex === this.listImage.length - 1
      ? (this.currentIndex = 0)
      : (this.currentIndex += 1);
  }
  onPreviousImg() {
    this.currentIndex === 0
      ? (this.currentIndex = this.listImage.length - 1)
      : (this.currentIndex -= 1);
  }
}
