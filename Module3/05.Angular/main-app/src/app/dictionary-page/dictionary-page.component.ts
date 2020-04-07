import { Component, OnInit } from "@angular/core";
import {
  DictionaryService,
  IWord,
} from "../_services/dictionary-service/dictionary.service";

@Component({
  selector: "app-dictionary-page",
  templateUrl: "./dictionary-page.component.html",
  styleUrls: ["./dictionary-page.component.scss"],
})
export class DictionaryPageComponent implements OnInit {
  listWord: IWord[] = [];
  constructor(private dictionaryService: DictionaryService) {}

  ngOnInit() {
    this.listWord = this.dictionaryService.getAll();
    console.log(this.listWord);
  }
}
