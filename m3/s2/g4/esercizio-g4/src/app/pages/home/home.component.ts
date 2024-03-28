import { Component } from '@angular/core';
import { PhotosService } from './../../photos.service';
import { iPhoto } from '../../Models/iphoto';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {

  photos: iPhoto[]=[];
  favorites: iPhoto[]=[];

  constructor(private photosSvc: PhotosService) { }

  ngOnInit(): void {
    this.photosSvc.$photos.subscribe(photos => {
      this.photos = photos;
    });
    this.photosSvc.$favorites.subscribe(favorites => {
      this.favorites = favorites;
    });
  }

  deletePhoto(id:number){
    this.photosSvc.delete(id).subscribe()
  }

  addToFavorites(id: number): void {
    this.photosSvc.addToFavorites(id);
  }
}
