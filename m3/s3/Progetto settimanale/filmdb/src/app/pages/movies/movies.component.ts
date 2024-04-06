import { Component } from '@angular/core';
import { MoviesService } from '../../movies.service';
import { iMovies } from '../../Models/imovies';
import { AuthService } from '../../auth/auth.service';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrl: './movies.component.scss'
})
export class MoviesComponent {

  movies: iMovies[]=[];

  constructor(private moviesSvc: MoviesService, private authSvc: AuthService) { }

  ngOnInit(): void {
    this.moviesSvc.$users.subscribe(movies => {
      this.movies = movies;
    });
  }

  deleteMovie(id:number){
    this.moviesSvc.delete(id).subscribe()
  }

  toggleFavorite(movie: iMovies) {
    const userId = this.authSvc.getCurrentUserId();
    if (!userId) {
      console.error('ID utente non valido');
      return;
    }

    if (movie.isFavorite) {
      this.authSvc.deleteFavorite(userId, movie.id).subscribe(() => {
        console.log('Film rimosso dai preferiti con successo!');
        movie.isFavorite = false;
      }, error => {
        console.error('Errore nella rimozione dai preferiti', error);
      });
    } else {
      this.authSvc.addFavorite(userId, movie.id).subscribe(() => {
        console.log('Film aggiunto ai preferiti con successo!');
        movie.isFavorite = true;
      }, error => {
        console.error('Errore nell\'aggiungere ai preferiti', error);
      });
    }
  }

}
