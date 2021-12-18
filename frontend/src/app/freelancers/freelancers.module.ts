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
import { TrabajoComponent } from './trabajos/trabajo/trabajo.component';
import {ReactiveFormsModule} from "@angular/forms";
import { PostulacionFormComponent } from './postulaciones/shared/postulacion-form/postulacion-form.component';
import { PostulacionComponent } from './postulaciones/postulaciones-list/postulacion/postulacion.component';
import {HttpClientModule} from "@angular/common/http";
import { PostulacionCardComponent } from './postulaciones/detail-postulacion/postulacion-card/postulacion-card.component';
import {IconsModule} from "../icons/icons.module";


@NgModule({
  declarations: [
    PostulacionesListComponent,
    NewPostulacionComponent,
    EditPostulacionComponent,
    LayoutComponent,
    HomeComponent,
    TrabajoListComponent,
    DetailPostulacionComponent,
    TrabajoComponent,
    PostulacionFormComponent,
    PostulacionComponent,
    PostulacionCardComponent,
  ],
    imports: [
        CommonModule,
        FreelancersRoutingModule,
        SharedModule,
        MaterialModule,
        FlexLayoutModule,
        ReactiveFormsModule,
        HttpClientModule,
        IconsModule
    ]
})
export class FreelancersModule { }
