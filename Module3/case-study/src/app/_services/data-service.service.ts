import { environment } from "./../../environments/environment";
import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { take } from "rxjs/operators";

@Injectable({
  providedIn: "root",
})
export class DataServiceService {
  constructor(private http: HttpClient) {}

  getData(type: string, limit?: number) {
    if (limit) {
      return this.http.get(`${environment.apiUrl}/${type}`).pipe(take(limit));
    }
    return this.http.get(`${environment.apiUrl}/${type}`);
  }
  updateData(type: string, data: any) {
    return this.http.put(`${environment.apiUrl}/${type}`, data);
  }
  // deleteData(type: string) {
  //   return this.http.delete(`/assets/${type}.json`)
  // }
  postData(type: string, data: any) {
    let id: number;
    this.getData(type).subscribe((oldData: any[]) => {
      id = oldData[oldData.length - 1].id;
      data["id"] = id;
    });
    return this.http.post(
      `${environment.apiUrl}/${type}`,
      JSON.stringify(data),
      {
        headers: new HttpHeaders().set("content-type", "application/json"),
      }
    );
  }
}
