import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {PatientSymptoms} from '../../model/patient-symptoms.model';

@Injectable({
  providedIn: 'root'
})
export class ResonerService {

  constructor(private http: HttpClient) { }

  getWithHighestPriority(symptoms: any) {

    return this.http.post('/api/reasoner/start', symptoms, {responseType: 'text'});
  }

  getAllForIllness(dto: any) {
    return this.http.post('/api/reasoner/start/illness', dto);
  }


  getAllDiseaseBySymptoms(dto: PatientSymptoms) {
    return this.http.post('/api/reasoner/start/symptoms', dto);

  }
}
