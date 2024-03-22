import { Component } from '@angular/core';
import { iCar } from '../../Models/icar';
import { CarsService } from '../../cars.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {

  carsArr: iCar[] = [];

  constructor(private carsSvc:CarsService){}

  ngOnInit(): void{

    this.carsSvc.getAllCars().then(res => {
      this.carsArr = res;
    });
  }
}
