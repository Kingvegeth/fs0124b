import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { iCar } from '../../Models/icar';
import { CarsService } from '../../cars.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrl: './details.component.scss'
})
export class DetailsComponent {
  car!: iCar;

  constructor(private route: ActivatedRoute, private carsSvc: CarsService) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const carId = Number(params.get('id'));
      this.carsSvc.getCarById(carId).then(res => {
        this.car = res;
      });
    });
  }
}
