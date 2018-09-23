import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class UserService {

  constructor(private http: HttpClient) {
  }

  isLoggedIn() {
    return localStorage.getItem('loggedUser') !== null;
  }

  getLoggedUser() {
    return JSON.parse(localStorage.getItem('loggedUser'));
  }

  login(user: any) {

    return this.http.post('/api/users/login', user);
  }

  logout(id: any) {

    return this.http.post('/api/users/logout/' + id, {});
  }

  register(user: any) {
    console.log(user);
    return this.http.post('/api/users', user);
  }
}
