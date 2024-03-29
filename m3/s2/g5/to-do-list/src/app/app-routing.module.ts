import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomepageComponent } from './pages/homepage/homepage.component';
import { CompletedComponent } from './pages/completed/completed.component';
import { IncompleteComponent } from './pages/incomplete/incomplete.component';
import { UsersComponent } from './pages/users/users.component';

const routes: Routes = [
  {
    path:'',
    component:HomepageComponent
  },
  {
    path:'completed',
    component:CompletedComponent
  },
  {
    path:'incomplete',
    component:IncompleteComponent
  },
  {
    path:'users',
    component:UsersComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
