import { Component } from '@angular/core';
import {Termin} from "../../model/termin";
import {HttpService} from "../../service/http.service";

@Component({
  selector: 'app-termin-overview',
  standalone: true,
  imports: [],
  templateUrl: './termin-overview.component.html',
  styleUrl: './termin-overview.component.css'
})
export class TerminOverviewComponent {
  termine: Termin[] = []

  constructor(private httpService: HttpService) {}

  ngOnInit(): void {
    this.httpService.getAllTermine().subscribe((data: Termin[]) => {
      console.log("this is data"+data)
      this.termine = data;
    });
  }
}
