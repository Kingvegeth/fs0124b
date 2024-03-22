import { Component } from '@angular/core';
import { iCar } from '../../Models/icar';
import { CarsService } from '../../cars.service';

@Component({
  selector: 'app-turiddu',
  templateUrl: './turiddu.component.html',
  styleUrl: './turiddu.component.scss'
})
export class TuridduComponent {
  turidduCars: iCar[] = [];

  constructor(private carsService: CarsService) {
    this.carsService.getCarsByBrand('Turiddu').then(car => {
      this.turidduCars = car;
    });
  }
}
