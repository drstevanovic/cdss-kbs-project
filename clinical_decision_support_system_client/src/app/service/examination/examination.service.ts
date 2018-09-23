import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {MedicalExamination} from '../../model/medical-examination.model';

@Injectable({
  providedIn: 'root'
})
export class ExaminationService {

  constructor(private http: HttpClient) { }

  add(examination: MedicalExamination, jmbg: any) {

    return this.http.post('/api/examinations/'+jmbg, examination);
  }
}
