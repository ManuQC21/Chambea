import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Trabajo} from "../../../../model/trabajo.model";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {HabilidadService} from "../../../../services/habilidad.service";
import {Habilidad} from "../../../../model/habilidad.model";

@Component({
  selector: 'app-trabajo-form',
  templateUrl: './trabajo-form.component.html',
  styleUrls: ['./trabajo-form.component.css']
})
export class TrabajoFormComponent implements OnInit {
  ngOnInit(): void {
  }


}

/*
idTrabajo?: number,
  titulo: string,
  descripcion: string,
  duracion: {
    idDuracion: number,
    descripcion: string
  },
  empleador: {
    idEmpleador: number,
    fechaRegistro?: string,
    compania?: string
  },
  habilidades: RequiereHabilidad[],
  postulaciones? : Object[],
  fecha?: string
 */
