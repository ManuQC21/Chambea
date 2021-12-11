import { Component, OnInit } from '@angular/core';
import {TrabajoService} from "../shared/trabajo.service";
import {Trabajo} from "../../../model/trabajo.model";
import {UsuarioDto} from "../../../model/usuarioDto";

@Component({
  selector: 'app-trabajo-list',
  templateUrl: './trabajo-list.component.html',
  styleUrls: ['./trabajo-list.component.css']
})
export class TrabajoListComponent implements OnInit {

  currentUser : UsuarioDto
  trabajos : Trabajo[] = []

  constructor(
    private trabajoService: TrabajoService
  ) {
    this.currentUser = JSON.parse(<string>localStorage.getItem("user"));
  }

  ngOnInit(): void {
    this.getTrabajos();
  }

  getTrabajos(){
    return this.trabajoService.getByEmpleador(this.currentUser.id)
      .subscribe((data : Trabajo[]) => {
        this.trabajos = data;
      })
  }

}
