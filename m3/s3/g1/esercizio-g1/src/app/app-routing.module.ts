import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './pages/auth/auth.guard';

const routes: Routes = [
  { path: '', 
    loadChildren: () => import('./pages/home/home.module').then(m => m.HomeModule) }, 
  { path: 'chi-siamo',
    loadChildren: () => import('./pages/chi-siamo/chi-siamo.module').then(m => m.ChiSiamoModule) }, 
  { path: 'account',
    loadChildren: () => import('./pages/account/account.module').then(m => m.AccountModule),
    canActivate : [AuthGuard],
    canActivateChild : [AuthGuard]
  },
  { path: 'auth', loadChildren: () => import('./pages/auth/auth.module').then(m => m.AuthModule) }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
