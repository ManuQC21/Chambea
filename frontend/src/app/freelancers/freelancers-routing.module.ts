import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LayoutComponent} from "../emp/layout/layout.component";
import {HomeComponent} from "./home/home.component";
import {TrabajoCardComponent} from "../emp/trabajos/detail-trabajo/trabajo-card/trabajo-card.component";
import {TrabajoListComponent} from "./trabajos/trabajo-list/trabajo-list.component";
import {DetailPostulacionComponent} from "./postulaciones/detail-postulacion/detail-postulacion.component";
import {EditPostulacionComponent} from "./postulaciones/edit-postulacion/edit-postulacion.component";
import {NewPostulacionComponent} from "./postulaciones/new-postulacion/new-postulacion.component";

const routes: Routes = [
  {
    path:'',
    component: LayoutComponent,
    children: [
      {
        path:'home',
        component:HomeComponent
      },
      {
        path:'trabajos',
        component:TrabajoListComponent
      },
      {
        path:'postulacion/new',
        component:NewPostulacionComponent
      },
      {
        path:'postulacion/:id',
        component: DetailPostulacionComponent,
        children: [
          {
            path: 'edit',
            component: EditPostulacionComponent
          },
          {
            path:'detail',
            component: TrabajoCardComponent
          }
        ]
      },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FreelancersRoutingModule { }
