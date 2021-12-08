import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

const routes: Routes = [
  {
    path: 'auth',
    loadChildren: () =>
      import('./auth/auth.module').then((m) => m.AuthModule)
  },
  {
    path: '',
    loadChildren: () =>
      import('./home/home.module').then((m) => m.HomeModule)
  },
  {
    path: 'emp',
    loadChildren: () =>
      import('./emp/emp.module').then((m) => m.EmpModule)
  },
  {
    path: 'freelancers',
    loadChildren: () =>
      import('./freelancers/freelancers.module').then((m) => m.FreelancersModule)
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
