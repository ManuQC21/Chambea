import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../../shared/auth.service";
import {Usuario} from "../../shared/usuario.model";

@Component({
  selector: 'app-signin-form',
  templateUrl: './signin-form.component.html',
  styleUrls: ['./signin-form.component.css']
})
export class SigninFormComponent implements OnInit {

  @Output() onSubmit : EventEmitter<Usuario> = new EventEmitter<Usuario>()

  usuario : Usuario = {
    email: '',
    password: '',
    nombreUsuario: '',
    nombres: '',
    apellidos: ''
  }

  form : FormGroup = this.formBuilder.group(
    {
      email: [
        this.usuario.email, [
          Validators.required
        ]
      ],
      nombreUsuario: [
        this.usuario.nombreUsuario, [
          Validators.required
        ]
      ],
      nombres: [
        this.usuario.nombres, [
          Validators.required
        ]
      ],
      apellidos: [
        this.usuario.apellidos, [
          Validators.required
        ]
      ],
      password: [
        this.usuario.password, [
          Validators.required
        ]
      ]
    }
  )

  constructor(private authService: AuthService,
              private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
  }

  signin(){
    this.onSubmit.emit(this.form.value)
  }

}
