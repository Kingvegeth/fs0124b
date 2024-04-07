import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { iLoginData } from '../../Models/ilogindata';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {

  loginData:iLoginData = {
    email:'simone@epicode.it',
    password:'password'
  }

  rememberMe: boolean = false;


  constructor(
    private authSvc:AuthService,
    private router:Router
    ){}

    signIn() {
      this.authSvc.login(this.loginData, this.rememberMe)
        .subscribe({
          next: (data) => {
            this.router.navigate(['/movies']);
          }
        });
    }

}
