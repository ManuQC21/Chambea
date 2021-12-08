import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AuthRoutingModule } from './auth-routing.module';
import { LoginComponent } from './login/login.component';
import { SigninComponent } from './signin/signin.component';
import { LoginFormComponent } from './login/login-form/login-form.component';
import { LayoutComponent } from './layout/layout.component';
import {MaterialModule} from "../material/material.module";
import {ReactiveFormsModule} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import { SigninFormComponent } from './signin/signin-form/signin-form.component';
import {SharedModule} from "../shared/shared.module";


@NgModule({
  declarations: [
    LoginComponent,
    SigninComponent,
    LoginFormComponent,
    LayoutComponent,
    SigninFormComponent
  ],
  imports: [
    CommonModule,
    AuthRoutingModule,
    MaterialModule,
    ReactiveFormsModule,
    SharedModule,
  ]
})
export class AuthModule { }
