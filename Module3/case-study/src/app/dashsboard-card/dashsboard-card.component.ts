import { Component, OnInit, Input } from "@angular/core";

@Component({
  selector: "app-dashsboard-card",
  templateUrl: "./dashsboard-card.component.html",
  styleUrls: ["./dashsboard-card.component.css"],
})
export class DashsboardCardComponent implements OnInit {
  @Input("cardValue") cardValue: string | number;
  @Input("cardTitle") cardTitle: string;
  @Input("cardColor") cardColor: string;
  constructor() {}

  ngOnInit(): void {}
}
