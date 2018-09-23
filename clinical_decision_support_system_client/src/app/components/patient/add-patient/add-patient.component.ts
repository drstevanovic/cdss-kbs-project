import {Component, OnInit} from '@angular/core';
import {MessageService} from '../../../service/message.service';
import {Router} from '@angular/router';
import {Patient} from '../../../model/patient.model';
import {PatientService} from '../../../service/patient/patient.service';

@Component({
  selector: 'app-add-patient',
  templateUrl: './add-patient.component.html',
  styleUrls: ['./add-patient.component.css']
})
export class AddPatientComponent implements OnInit {

  patient: Patient;
  ingredients: string[];
  ingredient: string;

  constructor(private patientService: PatientService, private messageService: MessageService, private router: Router) {
    this.patient = new Patient();

  }

  ngOnInit() {
    this.patient = new Patient();
    this.ingredients = [];
    this.patient.jmbg = '';

    this.ingredient = '';
  }

  registerUser() {
    this.patient.allergicIngredients = this.ingredients;
    this.patientService.register(this.patient).subscribe(() => {
      this.messageService.sendMessage('New patient successfully added.');
      this.router.navigate(['/account']);
    });
  }

  addIngredient() {
    this.ingredients.push(this.ingredient);
    this.ingredient = '';

  }
}
