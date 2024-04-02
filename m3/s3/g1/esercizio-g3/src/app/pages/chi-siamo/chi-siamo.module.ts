import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ChiSiamoRoutingModule } from './chi-siamo-routing.module';
import { ChiSiamoComponent } from './chi-siamo.component';
import { SharedModule } from '../../shared/shared.module';


@NgModule({
  declarations: [
    ChiSiamoComponent
  ],
  imports: [
    CommonModule,
    ChiSiamoRoutingModule,
    SharedModule
  ]
})
export class ChiSiamoModule { }
