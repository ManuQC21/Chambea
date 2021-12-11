import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FreelancersRoutingModule } from './freelancers-routing.module';
import { PostulacionesListComponent } from './postulaciones/postulaciones-list/postulaciones-list.component';
import { NewPostulacionComponent } from './postulaciones/new-postulacion/new-postulacion.component';
import { EditPostulacionComponent } from './postulaciones/edit-postulacion/edit-postulacion.component';
import { LayoutComponent } from './layout/layout.component';
import { HomeComponent } from './home/home.component';
import {SharedModule} from "../shared/shared.module";
import {MaterialModule} from "../material/material.module";
import {FlexLayoutModule} from "@angular/flex-layout";
import { TrabajoListComponent } from './trabajos/trabajo-list/trabajo-list.component';
import { DetailPostulacionComponent } from './postulaciones/detail-postulacion/detail-postulacion.component';


@NgModule({
  declarations: [
    PostulacionesListComponent,
    NewPostulacionComponent,
    EditPostulacionComponent,
    LayoutComponent,
    HomeComponent,
    TrabajoListComponent,
    DetailPostulacionComponent,
  ],
  imports: [
    CommonModule,
    FreelancersRoutingModule,
    SharedModule,
    MaterialModule,
    FlexLayoutModule
  ]
})
export class FreelancersModule { }
