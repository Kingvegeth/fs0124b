import { Component } from '@angular/core';
import { iProduct } from '../../Models/iproduct';
import { CartService } from '../../services/cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrl: './cart.component.scss'
})
export class CartComponent {
  cart: iProduct[] = [];
  total: number = 0;

  constructor(private cartSvc: CartService) { }

  ngOnInit(): void {
    this.cart = this.cartSvc.getCart();
    this.calculateTotal();
  }

  removeFromCart(product: iProduct): void {
    this.cartSvc.removeFromCart(product);
    this.calculateTotal();
  }

  private calculateTotal(): void {
    this.total = this.cartSvc.getTotal();
  }
}
