import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { AudiComponent } from './pages/audi/audi.component';
import { FiatComponent } from './pages/fiat/fiat.component';
import { FordComponent } from './pages/ford/ford.component';
import { DetailsComponent } from './pages/details/details.component';
import { TuridduComponent } from './pages/turiddu/turiddu.component';

const routes: Routes = [
  {
    path:'',
    component:HomeComponent
  },
  {
    path:'audi',
    component:AudiComponent
  },
  {
    path:'fiat',
    component:FiatComponent
  },
  {
    path:'ford',
    component:FordComponent
  },
  {
    path:'details/:id',
    component:DetailsComponent
  },
  {
    path:'turiddu',
    component:TuridduComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
