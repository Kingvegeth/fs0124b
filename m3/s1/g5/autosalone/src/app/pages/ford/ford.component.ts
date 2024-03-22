import { Component } from '@angular/core';
import { iCar } from '../../Models/icar';
import { CarsService } from '../../cars.service';

@Component({
  selector: 'app-ford',
  templateUrl: './ford.component.html',
  styleUrl: './ford.component.scss'
})
export class FordComponent {

  fordCars: iCar[] = [];

  constructor(private carsService: CarsService) {
    this.carsService.getCarsByBrand('Ford').then(car => {
      this.fordCars = car;
    });
  }

}
