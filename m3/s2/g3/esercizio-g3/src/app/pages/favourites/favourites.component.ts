import { Component, OnInit } from '@angular/core';
import { iProduct } from '../../Models/iproduct';
import { FavouritesService } from '../../services/favourites.service';

@Component({
  selector: 'app-favourites',
  templateUrl: './favourites.component.html',
  styleUrls: ['./favourites.component.scss']
})
export class FavouritesComponent{
  favourites: iProduct[] = [];

  constructor(private favouritesSvc: FavouritesService) { }

  ngOnInit(): void {
    this.favourites = this.favouritesSvc.getFavourites();
  }

  removeFromFavourites(product: iProduct): void {
    this.favouritesSvc.removeFromFavourites(product);
  }
}
