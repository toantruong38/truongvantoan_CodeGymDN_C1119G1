import { Subject } from "rxjs";
import { Injectable } from "@angular/core";

@Injectable({
  providedIn: "root",
})
export class DashboardService {
  private dashBoardData = new Subject<any>();
  dashBoardData$ = this.dashBoardData.asObservable();

  transfer(obj: any) {
    this.dashBoardData.next(obj);
  }
  constructor() {}
}
