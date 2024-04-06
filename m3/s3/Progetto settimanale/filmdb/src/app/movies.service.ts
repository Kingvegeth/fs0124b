import { Injectable } from '@angular/core';
import { iMovies } from './Models/imovies';
import { BehaviorSubject } from 'rxjs/internal/BehaviorSubject';
import { environment } from '../environments/environment.development';
import { HttpClient } from '@angular/common/http';
import { tap } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class MoviesService {

  moviesUrl = environment.moviesUrl;

  moviesArray: iMovies[]=[]

  moviesSubject = new BehaviorSubject<iMovies[]>([]);

  $users = this.moviesSubject.asObservable()

  constructor(private http:HttpClient){
    this.getAll().subscribe(data => {
      this.moviesSubject.next(data)
      this.moviesArray = data;
    })
  }

  getAll(){
    return this.http.get<iMovies[]>(this.moviesUrl)
  }

  delete(id:number){
    return this.http.delete<iMovies>(this.moviesUrl+ '/' +id)
    .pipe(tap(()=>{
      this.moviesArray = this.moviesArray.filter(p => p.id != id)
      this.moviesSubject.next(this.moviesArray)
    }))
  }
}
