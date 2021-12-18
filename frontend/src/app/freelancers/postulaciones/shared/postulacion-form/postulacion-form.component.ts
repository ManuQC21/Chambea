import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Form, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Postulacion} from "../../../../model/postulacion.model";
import {UsuarioDto} from "../../../../model/usuarioDto";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-postulacion-form',
  templateUrl: './postulacion-form.component.html',
  styleUrls: ['./postulacion-form.component.css']
})
export class PostulacionFormComponent implements OnInit {

  currentUser: UsuarioDto
  idTrabajo: any

  @Input() postulacion?: Postulacion
  @Output() onSubmit: EventEmitter<Postulacion> = new EventEmitter<Postulacion>()

  form: FormGroup

  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute
  ) {

    this.idTrabajo = this.route.snapshot.paramMap.get('id')
    this.currentUser = JSON.parse(<string>localStorage.getItem("user"));

    this.form = this.formBuilder.group(
      {
       freelancer: [
         {
           idFreelancer: this.currentUser.idFreelancer
         }
       ],
        descripcion: [
          this.postulacion?.descripcion,[
            Validators.required
          ],
        ],
        trabajo: [
          {
            idTrabajo: this.idTrabajo
          }
        ],
    }
    )
  }

  ngOnInit(): void {
    if (this.postulacion){
      this.form.patchValue(
        {
          descripcion: this.postulacion.descripcion,
        }
      )
      console.log(this.postulacion.descripcion)
    }
    console.log(this.postulacion)

  }

  save() {
    if (this.postulacion){
      this.postulacion.descripcion = this.form.value.descripcion
      console.log(this.form.value)
      this.onSubmit.emit(this.postulacion)
    }
    else {
      this.onSubmit.emit(this.form.value)
    }

  }

}
