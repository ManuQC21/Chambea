import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EmpRoutingModule } from './emp-routing.module';
import { HomeComponent } from './home/home.component';
import {FlexLayoutModule} from "@angular/flex-layout";
import {MaterialModule} from "../material/material.module";
import { TrabajoListComponent } from './trabajos/trabajo-list/trabajo-list.component';
import { EditTrabajoComponent } from './trabajos/edit-trabajo/edit-trabajo.component';
import { NewTrabajoComponent } from './trabajos/new-trabajo/new-trabajo.component';


@NgModule({
  declarations: [
    HomeComponent,
    TrabajoListComponent,
    EditTrabajoComponent,
    NewTrabajoComponent
  ],
    imports: [
        CommonModule,
        EmpRoutingModule,
        FlexLayoutModule,
        MaterialModule
    ]
})
export class EmpModule { }
