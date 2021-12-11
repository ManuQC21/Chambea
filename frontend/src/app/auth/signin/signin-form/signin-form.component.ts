import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../../shared/auth.service";
import {Usuario} from "../../shared/usuario.model";
import {CreateUserRequest} from "../../shared/user-creation.model";

@Component({
  selector: 'app-signin-form',
  templateUrl: './signin-form.component.html',
  styleUrls: ['./signin-form.component.css']
})
export class SigninFormComponent implements OnInit {

  @Output() onSubmit : EventEmitter<CreateUserRequest> = new EventEmitter<CreateUserRequest>()

  userCreate : CreateUserRequest = {
    email: '',
    password: '',
    rePassword: '',
    username: '',
    nombres: '',
    apellidos: ''
  }

  form : FormGroup = this.formBuilder.group(
    {
      email: [
        this.userCreate.email, [
          Validators.required
        ]
      ],
      username: [
        this.userCreate.username, [
          Validators.required
        ]
      ],
      nombres: [
        this.userCreate.nombres, [
          Validators.required
        ]
      ],
      apellidos: [
        this.userCreate.apellidos, [
          Validators.required
        ]
      ],
      password: [
        this.userCreate.password, [
          Validators.required
        ]
      ],
      rePassword: [
        this.userCreate.rePassword, [
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
    console.log(this.form.value)
  }

}
