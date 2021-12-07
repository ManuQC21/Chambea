import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FreelancersRoutingModule } from './freelancers-routing.module';
import { PostulacionesListComponent } from './postulaciones/postulaciones-list/postulaciones-list.component';
import { NewPostulacionComponent } from './postulaciones/new-postulacion/new-postulacion.component';
import { EditPostulacionComponent } from './postulaciones/edit-postulacion/edit-postulacion.component';


@NgModule({
  declarations: [
    PostulacionesListComponent,
    NewPostulacionComponent,
    EditPostulacionComponent
  ],
  imports: [
    CommonModule,
    FreelancersRoutingModule
  ]
})
export class FreelancersModule { }
