import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Medicine} from '../../model/medicine.model';

@Injectable({
  providedIn: 'root'
})
export class MedicineService {

  constructor(private http: HttpClient) {
  }

  getAll() {

    return this.http.get('/api/medicine');
  }

  checkValidity(selectedMedicines: Medicine[], jmbg: string) {

    return this.http.post('/api/examinations/validate-patient/' + jmbg, selectedMedicines);

  }

  add(medicine: Medicine) {
    return this.http.post('/api/medicine' ,medicine);

  }
}
