
import { Injectable } from '@angular/core';
import { iProduct } from '../Models/iproduct';

@Injectable({
  providedIn: 'root'
})
export class FavouritesService {
  favourites: iProduct[] = [];

  addToFavourites(product: iProduct): void {
    if (!this.favourites.some(item => item.id === product.id)) {
      this.favourites.push(product);
    }
  }

  removeFromFavourites(product: iProduct): void {
    const index = this.favourites.indexOf(product);
    if (index > -1) {
      this.favourites.splice(index, 1);
    }
  }

  getFavourites(): iProduct[] {
    return this.favourites;
  }
}
