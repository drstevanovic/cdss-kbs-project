import {Component, OnInit, ViewChild} from '@angular/core';
import {Illness} from '../../../model/illness.model';
import {IllnessService} from '../../../service/illness/illness.service';
import {Observable, Subject} from 'rxjs/Rx';
import {NgbTypeahead} from '@ng-bootstrap/ng-bootstrap';
import {MessageService} from '../../../service/message.service';
import {Router} from '@angular/router';
import {Symptom} from '../../../model/symptom.model';
import {SymptomService} from '../../../service/symptom/symptom.service';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-add-illness',
  templateUrl: './add-illness.component.html',
  styleUrls: ['./add-illness.component.css']
})
export class AddIllnessComponent implements OnInit {
  @ViewChild('instance') instance: NgbTypeahead;
  click$ = new Subject<string>();
  nameOfSymptoms: string[];
  addedSymptoms: string[];
  symptoms: Symptom[];
  illness: Illness;
  selectedSymptom: string;
  specific: boolean;
  specificList: boolean[];

  constructor(private illnessService: IllnessService, private messageService: MessageService,
              private symptomService: SymptomService, private router: Router, private toastr: ToastrService) {
  }

  ngOnInit() {
    this.illness = new Illness();
    this.nameOfSymptoms = [];
    this.symptoms = [];
    this.addedSymptoms = [];
    this.selectedSymptom = '';
    this.specificList = [];
    this.specific = false;
    this.getAllSymptoms();
  }


  addIllness() {
    for (let i = 0; i < this.addedSymptoms.length; i++) {
      this.illness.symptoms.push(new Symptom(this.addedSymptoms[i], this.specificList[i]));
    }
    this.illnessService.add(this.illness).subscribe(() => {
      this.messageService.sendMessage('New disease successfully added.');
      this.router.navigate(['/account']);
    }, (error) => {
      if (error.status === 409) {
        this.toastr.error('Disease with that name already exist!');
      }
      return;
    });
  }


  searchSymptoms = (text$: Observable<string>) =>
    text$
      .debounceTime(200)
      .merge(this.click$.filter(() => !this.instance.isPopupOpen()))
      .map(term => term === '' ? this.nameOfSymptoms
        : this.nameOfSymptoms.filter(v => {
          return (v.toLowerCase().indexOf(term.toLowerCase()) > -1);
        }));

  private getAllSymptoms() {
    this.nameOfSymptoms = [];
    this.symptomService.getAll().subscribe(result => {
      this.symptoms = result as Symptom[];
      for (const symptom of this.symptoms) {
        this.nameOfSymptoms.push(symptom.name);
      }
    });
  }

  addSymptom() {
    console.log(this.addedSymptoms);
    console.log(this.specificList);
    this.specificList.push(this.specific);
    this.addedSymptoms.push(this.selectedSymptom);
    const index = this.nameOfSymptoms.indexOf(this.selectedSymptom);
    this.nameOfSymptoms.splice(index, 1);
    this.selectedSymptom = '';
  }

  deleteSymptom(symptom) {
    const index = this.addedSymptoms.indexOf(symptom);
    this.addedSymptoms.splice(index, 1);
    this.specificList.splice(index, 1);
    this.nameOfSymptoms.push(symptom);
  }

}
