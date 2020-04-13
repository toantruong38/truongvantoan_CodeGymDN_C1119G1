import { TableInfo } from "./../../_models/table-info";
import { Injectable } from "@angular/core";
import { Subject } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class TableService {
  private sharedTableData = new Subject<TableInfo>();
  sharedTableData$ = this.sharedTableData.asObservable();

  transferData(data: TableInfo) {
    this.sharedTableData.next(data);
  }
  constructor() {}
}
