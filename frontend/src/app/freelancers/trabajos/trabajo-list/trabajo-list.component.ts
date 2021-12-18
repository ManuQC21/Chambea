import { Component, OnInit } from '@angular/core';
import {TrabajoService} from "../../../emp/trabajos/shared/trabajo.service";
import {UsuarioDto} from "../../../model/usuarioDto";
import {Trabajo} from "../../../model/trabajo.model";

@Component({
  selector: 'app-trabajo-list',
  templateUrl: './trabajo-list.component.html',
  styleUrls: ['./trabajo-list.component.css']
})
export class TrabajoListComponent implements OnInit {

  currentUser?: UsuarioDto
  trabajos?: Trabajo[]

  constructor(
    private trabajoService: TrabajoService
  ) {
    this.currentUser = JSON.parse(<string>localStorage.getItem("user"));
    this.getTrabajos()
    this.filterTrabajos()
  }

  ngOnInit(): void {
  }

  getTrabajos(){
    this.trabajoService.get()
      .subscribe(data=>{
        this.trabajos = data;
        this.filter()

      })
  }

  filterTrabajos(){
    if (this.trabajos){
      this.trabajos?.forEach( trabajo => {
        if (trabajo.empleador.idEmpleador == this.currentUser?.id){
          let index: any;
          index = this.trabajos?.indexOf(trabajo);
          if (index > -1)
            this.trabajos?.splice(index, 1)
        }
      })
      console.log('Filtrando')
      console.log(this.trabajos)
    }
  }

  filter(){
    if (this.trabajos){
      this.trabajos = this.trabajos.filter(
        trabajo => trabajo.empleador.idEmpleador!=this.currentUser?.id
      )
    }
  }


}
