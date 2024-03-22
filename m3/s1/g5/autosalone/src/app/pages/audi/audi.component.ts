import { Component } from '@angular/core';
import { iCar } from '../../Models/icar';
import { CarsService } from '../../cars.service';

@Component({
  selector: 'app-audi',
  templateUrl: './audi.component.html',
  styleUrls: [
    '../../../styles.scss',
    './audi.component.scss'
  ]
})
export class AudiComponent {
  audiCars: iCar[] = [];

  constructor(private carsService: CarsService) {
    this.carsService.getCarsByBrand('Audi').then(car => {
      this.audiCars = car;
    });
  }
}
