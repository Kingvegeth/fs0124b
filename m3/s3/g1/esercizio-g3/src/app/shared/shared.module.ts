import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { WipAlertComponent } from './wip-alert/wip-alert.component';



@NgModule({
  declarations: [
    WipAlertComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    WipAlertComponent
  ]
})
export class SharedModule { }
