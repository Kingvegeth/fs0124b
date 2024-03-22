import { Injectable } from '@angular/core';
import { iCar } from './Models/icar'

@Injectable({
  providedIn: 'root'
})
export class CarsService {

  carsArr: iCar[] = [];

  getAllCars(): Promise<iCar[]>{
    return fetch('../assets/db.json')
      .then(res => res.json())
      .then(res =>{
        this.carsArr = res;
        return this.carsArr
      })
  }

  getCarsByBrand(brand:string): Promise<iCar[]> {
    return this.getAllCars().then(cars => {
      return cars.filter(car => car.brand === brand);
    });
  }


  getCarById(id: number): Promise<iCar | any> {
    return this.getAllCars().then(cars => {
      return cars.find(car => car.id === id);
    });
  }

}
