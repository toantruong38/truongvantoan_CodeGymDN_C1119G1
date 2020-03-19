import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-pet",
  templateUrl: "./pet.component.html",
  styleUrls: ["./pet.component.css"]
})
export class PetComponent implements OnInit {
  petName: string;
  petImg: string;
  constructor() {}

  ngOnInit(): void {
    this.petName = "Phu quy";
    this.petImg =
      "https://upload.wikimedia.org/wikipedia/commons/thumb/d/dd/Le%C3%AFko_au_bois_de_la_Cambre.jpg/220px-Le%C3%AFko_au_bois_de_la_Cambre.jpg";
  }

  handlePetNameChange(name: string) {
    this.petName = name;
    console.log(this.petName);
  }
  handlePetImgChange(img: string) {
    this.petImg = img;
    console.log(this.petImg);
  }
}
