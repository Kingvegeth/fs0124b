import { Component } from '@angular/core';
import { iCar } from '../../Models/icar';
import { CarsService } from '../../cars.service';

@Component({
  selector: 'app-fiat',
  templateUrl: './fiat.component.html',
  styleUrl: './fiat.component.scss'
})
export class FiatComponent {

  fiatCars: iCar[] = [];

  constructor(private carsService: CarsService) {
    this.carsService.getCarsByBrand('Fiat').then(car => {
      this.fiatCars = car;
    });
  }

}
