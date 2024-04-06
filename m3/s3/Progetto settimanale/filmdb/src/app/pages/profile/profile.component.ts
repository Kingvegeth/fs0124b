import { Component } from '@angular/core';
import { iUsers } from '../../Models/iusers';
import { AuthService } from '../../auth/auth.service';
import { MoviesService } from '../../movies.service';
import { iMovies } from '../../Models/imovies';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.scss'
})
export class ProfileComponent {

  currentUser: iUsers | null = null;
  favoriteMovies: iMovies[] = [];

  constructor(private authService: AuthService, private moviesService: MoviesService) { }

  ngOnInit(): void {
    this.authService.user$.subscribe(user => {
      this.currentUser = user;
      if(user && user.favorites && user.favorites.length) {
        this.moviesService.getFavorites(user.favorites).subscribe(movies => {
          this.favoriteMovies = movies;
        });
      } else {
        this.favoriteMovies = [];
      }
    });
  }


  removeFromFavorites(movieId: number): void {
    const userId = this.authService.getCurrentUserId();
    if (userId) {
      this.authService.deleteFavorite(userId, movieId).subscribe({
        next: (response) => {
          console.log('Film rimosso dai preferiti con successo!');
          this.favoriteMovies = this.favoriteMovies.filter(movie => movie.id !== movieId);
        },
        error: (error) => {
          console.error('Errore nella rimozione dai preferiti', error);
        }
      });
    } else {
      console.error('ID utente non valido');
    }
  }
}


