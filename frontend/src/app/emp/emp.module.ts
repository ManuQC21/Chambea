import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EmpRoutingModule } from './emp-routing.module';
import { HomeComponent } from './home/home.component';
import {FlexLayoutModule} from "@angular/flex-layout";
import {MaterialModule} from "../material/material.module";
import { TrabajoListComponent } from './trabajos/trabajo-list/trabajo-list.component';
import { EditTrabajoComponent } from './trabajos/edit-trabajo/edit-trabajo.component';
import { NewTrabajoComponent } from './trabajos/new-trabajo/new-trabajo.component';
import { LayoutComponent } from './layout/layout.component';
import {SharedModule} from "../shared/shared.module";
import { DetailTrabajoComponent } from './trabajos/detail-trabajo/detail-trabajo.component';
import { TrabajoComponent } from './trabajos/trabajo-list/trabajo/trabajo.component';
import {IconsModule} from "../icons/icons.module";
import { TrabajoCardComponent } from './trabajos/detail-trabajo/trabajo-card/trabajo-card.component';
import { BreadcrumbComponent } from './trabajos/detail-trabajo/breadcrumb/breadcrumb.component';
import { PropuestasComponent } from './trabajos/detail-trabajo/propuestas/propuestas.component';
import { TrabajoFormComponent } from './trabajos/shared/trabajo-form/trabajo-form.component';
import {ReactiveFormsModule} from "@angular/forms";


@NgModule({
  declarations: [
    HomeComponent,
    TrabajoListComponent,
    EditTrabajoComponent,
    NewTrabajoComponent,
    LayoutComponent,
    DetailTrabajoComponent,
    TrabajoComponent,
    TrabajoCardComponent,
    BreadcrumbComponent,
    PropuestasComponent,
    TrabajoFormComponent,
  ],
    imports: [
        CommonModule,
        EmpRoutingModule,
        FlexLayoutModule,
        MaterialModule,
        SharedModule,
        IconsModule,
        ReactiveFormsModule
    ]
})
export class EmpModule { }
