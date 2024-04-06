import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { iUsers } from './Models/iusers';
import { BehaviorSubject } from 'rxjs/internal/BehaviorSubject';
import { environment } from '../environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  usersUrl = environment.usersUrl;

  usersArray: iUsers[]=[]

  usersSubject = new BehaviorSubject<iUsers[]>([]);

  $users = this.usersSubject.asObservable()

  constructor(private http:HttpClient){
    this.getAll().subscribe(data => {
      this.usersSubject.next(data)
      this.usersArray = data;
    })
  }



  getAll(){
    return this.http.get<iUsers[]>(this.usersUrl)
  }

  updateUsersList(): void {
    this.getAll().subscribe(users => {
      this.usersSubject.next(users);
    });
  }

}
