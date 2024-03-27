import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { FavouritesComponent } from './pages/favourites/favourites.component';
import { CartComponent } from './pages/cart/cart.component';

const routes: Routes = [
  {
    path:'',
    component: HomeComponent
  },
  {
    path:'favourites',
    component:FavouritesComponent
  },
  {
    path:'cart',
    component:CartComponent
  }

  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
