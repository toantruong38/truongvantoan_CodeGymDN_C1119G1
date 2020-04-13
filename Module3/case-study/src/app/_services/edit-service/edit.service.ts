import { Subject } from "rxjs";
import { Injectable } from "@angular/core";

@Injectable({
  providedIn: "root",
})
export class EditService {
  private state = new Subject<Object[]>();
  state$ = this.state.asObservable();

  transfer(stuffs: Object[]) {
    this.state.next(stuffs);
  }
  constructor() {}
}
