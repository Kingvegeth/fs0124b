import { iPhoto } from './Models/iphoto';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, tap } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class PhotosService {

  apiUrl:string = 'https://jsonplaceholder.typicode.com/photos';

  photosArray: iPhoto[]=[]
  favoritesArray: iPhoto[] = [];

  photosSubject = new BehaviorSubject<iPhoto[]>([]);
  favoritesSubject = new BehaviorSubject<iPhoto[]>([]);

  $photos = this.photosSubject.asObservable()
  $favorites = this.favoritesSubject.asObservable();

  constructor(private http:HttpClient){
    this.getAll().subscribe(data => {
      this.photosSubject.next(data)
      this.photosArray = data;
    })
  }

  getAll(){
    return this.http.get<iPhoto[]>(this.apiUrl)
  }

  getById(id:number){
    return this.photosArray.find(p => p.id == id)
  }


  delete(id:number){
    return this.http.delete<iPhoto>(this.apiUrl+'/'+id)
    .pipe(tap(()=>{
      this.photosArray = this.photosArray.filter(p => p.id != id)
      this.photosSubject.next(this.photosArray)
    }))
  }

  addToFavorites(id: number): void {
    const photoToAdd = this.getById(id);
    if (photoToAdd) {
      if(!this.favoritesArray.some(item => item.id === id))
      this.favoritesArray.push(photoToAdd);
      this.favoritesSubject.next(this.favoritesArray);
    }
  }
}
