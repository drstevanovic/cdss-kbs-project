import {Component, OnInit} from '@angular/core';
import {Medicine} from '../../../model/medicine.model';
import {MessageService} from '../../../service/message.service';
import {Router} from '@angular/router';
import {MedicineService} from '../../../service/medicine/medicine.service';

@Component({
  selector: 'app-add-medicines',
  templateUrl: './add-medicines.component.html',
  styleUrls: ['./add-medicines.component.css']
})
export class AddMedicinesComponent implements OnInit {

  medicine: Medicine;
  ingredients: string[];
  ingredient: string;
  showAdded: string;
  constructor(private medicineService: MedicineService, private messageService: MessageService, private router: Router) {
  }

  ngOnInit() {
    this.medicine = new Medicine();
    this.ingredient = '';
    this.ingredients = [];
    this.showAdded = '';

  }

  addMedicine() {
    this.medicine.ingredients = this.ingredients;
    this.medicineService.add(this.medicine).subscribe(() => {
      this.messageService.sendMessage('New medicine successfully added.');
      this.router.navigate(['/account']);
    });
  }

  addIngredient() {
    this.showAdded += this.ingredients + ' ';
    this.ingredients.push(this.ingredient);
    this.ingredient = '';

  }

}
