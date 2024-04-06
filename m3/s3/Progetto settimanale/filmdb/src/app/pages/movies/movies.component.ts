import { Component } from '@angular/core';
import { MoviesService } from '../../movies.service';
import { iMovies } from '../../Models/imovies';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrl: './movies.component.scss'
})
export class MoviesComponent {

  movies: iMovies[]=[];

  constructor(private moviesSvc: MoviesService) { }

  ngOnInit(): void {
    this.moviesSvc.$users.subscribe(movies => {
      this.movies = movies;
    });
  }

  deleteMovie(id:number){
    this.moviesSvc.delete(id).subscribe()
  }

}
