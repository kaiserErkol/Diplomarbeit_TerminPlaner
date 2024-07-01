import { Injectable } from '@angular/core';
import {BehaviorSubject, Subject} from "rxjs";
import {Termin} from "../model/termin";

@Injectable({
  providedIn: 'root'
})
export class TerminService {
  private subject: Subject<Termin> = new BehaviorSubject({} as Termin);

  constructor() { }
}
