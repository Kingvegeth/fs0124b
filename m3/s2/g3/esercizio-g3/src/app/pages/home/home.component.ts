import { Component } from '@angular/core';
import { iProduct } from '../../Models/iproduct';
import { ProductsService } from '../../services/products.service';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {

  products:iProduct[]=[]

  constructor(private productSvc:ProductsService){}

  ngOnInit(): void {
    this.productSvc.getProducts().subscribe(response => {
      this.products = response.products;
    });
  }


}
