import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-wip-alert',
  templateUrl: './wip-alert.component.html',
  styleUrl: './wip-alert.component.scss'
})
export class WipAlertComponent {

  @Input() testo!:string;

}
