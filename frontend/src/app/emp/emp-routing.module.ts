import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {LayoutComponent} from "./layout/layout.component";
import {NewTrabajoComponent} from "./trabajos/new-trabajo/new-trabajo.component";
import {EditTrabajoComponent} from "./trabajos/edit-trabajo/edit-trabajo.component";
import {DetailTrabajoComponent} from "./trabajos/detail-trabajo/detail-trabajo.component";
import {PropuestasComponent} from "./trabajos/detail-trabajo/propuestas/propuestas.component";
import {TrabajoCardComponent} from "./trabajos/detail-trabajo/trabajo-card/trabajo-card.component";

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
        path:'trabajo/new',
        component:NewTrabajoComponent
      },
      {
        path:'trabajo/:id',
        component: DetailTrabajoComponent,
        children: [
          {
            path: 'edit',
            component: EditTrabajoComponent
          },
          {
            path:'detail',
            component: TrabajoCardComponent
          },
          {
            path:'propuestas',
            component: PropuestasComponent
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
export class EmpRoutingModule { }
