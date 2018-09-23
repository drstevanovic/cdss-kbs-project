import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ReportService {

  constructor(private http: HttpClient) {


  }


  getAllChronic() {

    return this.http.get('/api/reports/chronic-patients');
  }

  getAllAddict() {

    return this.http.get('/api/reports/addict-patients');
  }

  getAllImmunity() {

    return this.http.get('/api/reports/immunity');
  }


}
