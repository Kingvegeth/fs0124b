import { Component } from '@angular/core';
import { iUsers } from '../../Models/iusers';
import { AuthService } from '../../auth/auth.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.scss'
})
export class ProfileComponent {

  currentUser: iUsers | null = null;

  constructor(private authService: AuthService) { }

  ngOnInit(): void {

    this.authService.user$.subscribe(user => {
      this.currentUser = user;
    });
  }

}
