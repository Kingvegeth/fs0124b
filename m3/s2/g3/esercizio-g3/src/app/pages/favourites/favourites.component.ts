import { Component, OnInit } from '@angular/core';
import { iProduct } from '../../Models/iproduct';
import { FavouritesService } from '../../services/favourites.service';
import { CartService } from '../../services/cart.service';


@Component({
  selector: 'app-favourites',
  templateUrl: './favourites.component.html',
  styleUrls: ['./favourites.component.scss']
})
export class FavouritesComponent{
  favourites: iProduct[] = [];
  showAlert: boolean = false;

  constructor(
    private favouritesSvc: FavouritesService,
    private cartSvc: CartService
    ) { }

  ngOnInit(): void {
    this.favourites = this.favouritesSvc.getFavourites();
  }

  removeFromFavourites(product: iProduct): void {
    this.favouritesSvc.removeFromFavourites(product);
  }

  addToCart(product: iProduct): void {
    this.cartSvc.addToCart(product);
    this.showAlert = true;
    setTimeout(() => {
      this.showAlert = false;
    }, 1000);
  }
}
