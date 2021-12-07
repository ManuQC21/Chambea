import { Component, OnInit } from '@angular/core';
import {TrabajoService} from "../shared/trabajo.service";
import {Trabajo} from "../../../model/trabajo.model";

@Component({
  selector: 'app-trabajo-list',
  templateUrl: './trabajo-list.component.html',
  styleUrls: ['./trabajo-list.component.css']
})
export class TrabajoListComponent implements OnInit {

  trabajos : Trabajo[] = []

  constructor(
    private trabajoService: TrabajoService
  ) { }

  ngOnInit(): void {
    this.getTrabajos();
  }

  getTrabajos(){
    return this.trabajoService.get()
      .subscribe((data : Trabajo[]) => {
        this.trabajos = data;
      })
  }

}
