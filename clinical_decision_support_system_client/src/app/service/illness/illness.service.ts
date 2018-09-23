import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Illness} from '../../model/illness.model';
@Injectable({
  providedIn: 'root'
})
export class IllnessService {

  constructor(private http: HttpClient) {
   }

   getAll() {

    return this.http.get('/api/illness');
  }

  add(illness: Illness) {
    return this.http.post('/api/illness', illness);

  }
}
