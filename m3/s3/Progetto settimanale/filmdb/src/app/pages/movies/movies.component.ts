import { Component} from '@angular/core';
import { MoviesService } from '../../movies.service';
import { iMovies } from '../../Models/imovies';
import { AuthService } from '../../auth/auth.service';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.scss']
})
export class MoviesComponent {

  movies: iMovies[] = [];

  constructor(private moviesSvc: MoviesService, private authSvc: AuthService) { }

  ngOnInit(): void {
    console.log('Caricamento dei film...');
    this.moviesSvc.getAll().subscribe(allMovies => {
      console.log('Dati di tutti i film recuperati:', allMovies);
      this.movies = allMovies;
      const userId = this.authSvc.getCurrentUserId();
      if (userId) {
        const user = this.authSvc.authSubject.value;
        const favoriteIds = user ? user.favorites || [] : [];
        this.movies.forEach(movie => {
          movie.isFavorite = favoriteIds.includes(movie.id);
        });
      }
    });
    console.log('Fine caricamento dei film.');
  }

  deleteMovie(id: number): void {
    this.moviesSvc.delete(id).subscribe();
  }

  toggleFavorite(movie: iMovies): void {
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
