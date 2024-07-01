import {inject, Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Termin} from "../model/termin";


@Injectable({
  providedIn: 'root'
})
export class HttpService {
  SERVER = 'http://localhost:8080/Termin/';
  http = inject(HttpClient)

  constructor() {
  }

  getAllTermine() {
    return this.http.get<Termin[]>(this.SERVER + "getallbooks");
  }
}
