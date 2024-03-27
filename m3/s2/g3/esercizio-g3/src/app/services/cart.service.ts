import { Injectable } from '@angular/core';
import { iProduct } from '../Models/iproduct';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  cart: iProduct[] = [];

  addToCart(product: iProduct): void {
    if (!this.cart.some(item => item.id === product.id)) {
      this.cart.push(product);
    }
  }

  removeFromCart(product: iProduct): void {
    const index = this.cart.indexOf(product);
    if (index > -1) {
      this.cart.splice(index, 1);
    }
  }

  getCart(): iProduct[] {
    return this.cart;
  }
}
