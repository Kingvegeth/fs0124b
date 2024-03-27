import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { iProducts } from '../Models/iproduct';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  private apiUrl = 'https://dummyjson.com/products';

  constructor(private http: HttpClient) { }

  getProducts(): Observable<iProducts> {
    return this.http.get<iProducts>(this.apiUrl);
  }

}
