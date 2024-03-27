import { Component, OnInit } from '@angular/core';
import { iProduct } from '../../Models/iproduct';
import { ProductsService } from '../../services/products.service';
import { FavouritesService } from '../../services/favourites.service';

@Component({
  selector: 'app-favourites',
  templateUrl: './favourites.component.html',
  styleUrl: './favourites.component.scss'
})
export class FavouritesComponent implements OnInit {
  favourites: iProduct[] = [];

  constructor(public favouritesSvc: FavouritesService) { }

  ngOnInit(): void {
    this.favourites = this.favouritesSvc.getFavourites();
    console.log(this.favourites);

  }
}
