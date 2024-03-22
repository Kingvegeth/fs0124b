import { Component } from '@angular/core';
import { iCar } from '../../Models/icar';
import { CarsService } from '../../cars.service';

@Component({
  selector: 'app-disclaimer',
  templateUrl: './disclaimer.component.html',
  styleUrl: './disclaimer.component.scss'
})
export class DisclaimerComponent {

  brands: string[] = []

  constructor(private carsSvc:CarsService){}

  ngOnInit(){

    this.carsSvc.getAllCars().then(res => {
      this.brands = this.getBrands(res);
    });
  }

  private getBrands(cars: iCar[]): string[] {
    const brandsSet = new Set<string>();
    cars.forEach(car => brandsSet.add(car.brandLogo));
    console.log(Array.from(brandsSet));

    return Array.from(brandsSet);


  }
}
