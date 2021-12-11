import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Trabajo} from "../../../../model/trabajo.model";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {HabilidadService} from "../../../../services/habilidad.service";
import {Habilidad} from "../../../../model/habilidad.model";
import {UsuarioDto} from "../../../../model/usuarioDto";
import {Duracion} from "../../../../model/duracion.model";
import {TrabajoService} from "../trabajo.service";
import {DatePipe} from "@angular/common";

@Component({
  selector: 'app-trabajo-form',
  templateUrl: './trabajo-form.component.html',
  styleUrls: ['./trabajo-form.component.css']
})
export class TrabajoFormComponent implements OnInit {
  habilidades?: Habilidad[]
  duraciones?: Duracion[]
  currentUser: UsuarioDto


  @Input() trabajo?: Trabajo
  @Output() onSubmit : EventEmitter<Trabajo> = new EventEmitter()

  form : FormGroup

  constructor(
    private formBuilder: FormBuilder,
    private habilidadService: HabilidadService,
    private trabajoService: TrabajoService,
    private datePipe: DatePipe
  ) {

    this.currentUser = JSON.parse(<string>localStorage.getItem("user"));
    this.getHabilidades();
    this.getDuraciones()


    this.form = this.formBuilder.group(
      {
        empleador: [
          {idEmpleador : this.currentUser.id}
        ],
        fecha: [
          this.datePipe.transform(Date.now(),"dd/MM/yyyy")
        ],
        titulo: [
          this.trabajo?.titulo, [
            Validators.required
          ]
        ],
        descripcion: [
          this.trabajo?.descripcion, [
            Validators.required
          ]
        ],
        duracion: [
          this.trabajo?.duracion, [
            Validators.required
          ]
        ],
        habilidades: [
          this.trabajo?.habilidades,[
            Validators.required
          ]
        ],
      }
    )




  }

  save(){
    console.log(this.form.value)
    this.onSubmit.emit(this.form.value);
  }

  ngOnInit(): void {
    if (this.trabajo){

      this.form.patchValue(
        {
          titulo: this.trabajo.titulo,
          descripcion: this.trabajo.descripcion,
          duracion: this.trabajo.duracion,
          habilidades: this.trabajo.habilidades
        }
      )
      const selectedDuracion = JSON.stringify(this.trabajo.duracion);

      console.log(selectedDuracion)

      let toPatch = {
        idDuracion : 0,
        descripcion: ''
      }

      toPatch.idDuracion = this.trabajo.duracion.idDuracion
      toPatch.descripcion = this.trabajo.duracion.descripcion

      // @ts-ignore

      // @ts-ignore
      //console.log('parche')
      //console.log(this.form.get('duracion')?.value)
      //console.log(this.form.get('duracion')?.value == this.trabajo.duracion)
      //console.log(this.trabajo.duracion)
      //console.log(this.form.get('habilidades')?.value == this.trabajo.habilidades)
    }
  }

  getHabilidades(): void{
    this.habilidadService.getAll().subscribe(
      data => {
        this.habilidades = data;
        //console.log(data)

      }
    )
  }

  getDuraciones(): void{
    this.trabajoService.getDuraciones().subscribe(
      data =>{
        this.duraciones = data;
      }
    )
  }


}
