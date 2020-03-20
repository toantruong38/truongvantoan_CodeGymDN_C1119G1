import { Component, OnInit, Input } from "@angular/core";

@Component({
  selector: "app-name-card",
  templateUrl: "./name-card.component.html",
  styleUrls: ["./name-card.component.css"]
})
export class NameCardComponent implements OnInit {
  @Input("cardName") cardName: string;
  @Input("email") email: string;
  @Input("phone") phone: string;
  constructor() {}

  ngOnInit(): void {}
}
