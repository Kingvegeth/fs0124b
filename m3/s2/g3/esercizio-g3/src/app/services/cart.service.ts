import { Injectable } from '@angular/core';
import { iProduct } from '../Models/iproduct';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  cart: iProduct[] = [];

  addToCart(product: iProduct): void {
      this.cart.push(product);
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

  getTotal(): number {
    let total = 0;
    for (let product of this.cart) {
      total += product.price;
      console.log('Valore del totale:', total);
    }
    return total;
  }
}
