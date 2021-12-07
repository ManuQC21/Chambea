import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../../shared/auth.service";

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  @Output() onSubmit : EventEmitter<any> = new EventEmitter<any>();


  form : FormGroup = this.formBuilder.group({
    username: [
      '',[
        Validators.required,
        Validators.minLength(5)
      ]
    ],
    password: [
      '',[
        Validators.required,
      ]
    ]
  })

  constructor(
    private formBuilder: FormBuilder,
  ) { }

  ngOnInit(): void {
  }

  login(){
    this.onSubmit.emit(this.form.value);
  }

}
