import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { iUsers } from '../../Models/iusers';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {

  registerData: Partial<iUsers> = {};

  constructor(
    private authSvc: AuthService,
    private router: Router
  ) { }

  signUp(): void {
    this.authSvc.register(this.registerData)
      .subscribe(data => {
        this.router.navigate(['/movies']);
      });
  }
}
