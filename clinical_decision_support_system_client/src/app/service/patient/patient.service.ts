import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Patient} from '../../model/patient.model';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  constructor(private http: HttpClient) { }

  findByJmbg(jmbg: any) {

    return this.http.get('/api/patients/' + jmbg);
  }

  findAll() {
    return this.http.get('/api/patients');
  }

  register(patient: Patient) {
    return this.http.post('/api/patients', patient);

  }
}
