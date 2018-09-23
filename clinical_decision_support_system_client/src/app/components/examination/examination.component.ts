import {Component, OnInit, ViewChild} from '@angular/core';
import {ResonerService} from '../../service/resoner/resoner.service';
import {Patient} from '../../model/patient.model';
import {PatientService} from '../../service/patient/patient.service';
import {IllnessService} from '../../service/illness/illness.service';
import {MessageService} from '../../service/message.service';
import {ToastrService} from 'ngx-toastr';
import {Observable, Subject} from 'rxjs/Rx';
import {NgbTypeahead} from '@ng-bootstrap/ng-bootstrap';
import {Symptom} from '../../model/symptom.model';
import {SymptomService} from '../../service/symptom/symptom.service';
import {PatientSymptoms} from '../../model/patient-symptoms.model';
import {Illness} from '../../model/illness.model';
import {Medicine} from '../../model/medicine.model';
import {MedicineService} from '../../service/medicine/medicine.service';
import {MedicalExamination} from '../../model/medical-examination.model';
import {ExaminationService} from '../../service/examination/examination.service';
import {SecurityUtil} from '../../utils/security-util';
import {Router} from '@angular/router';

@Component({
  selector: 'app-examination',
  templateUrl: './examination.component.html',
  styleUrls: ['./examination.component.css']
})
export class ExaminationComponent implements OnInit {

  @ViewChild('instance') instance: NgbTypeahead;
  click$ = new Subject<string>();

  addedSymptoms: string[];
  selectedSymptom: string;
  showInputDisease: boolean;
  showInputSymptos: boolean;
  showForPriority: boolean;
  highestDisease: string;
  patient: Patient;
  jmbg: string;
  symptoms: Symptom[];
  nameOfSymptoms: string[];
  nameOfIllness: string[];
  sortedDiseases: any[];
  illnessForSearch: string;
  patients: Patient[];
  patientChoosen: boolean;
  medicines: any;
  selectedMedicines: Medicine[];
  allergic: any;
  finalIllness: string;
  loading: boolean;

  constructor(private resonerService: ResonerService, private messageService: MessageService, private patientService: PatientService,
              private toastr: ToastrService, private symptomService: SymptomService,
              private illnessService: IllnessService, private medicineService: MedicineService,
              private examinationService: ExaminationService, private router: Router) {
  }

  ngOnInit() {

    if (SecurityUtil.isEmpty()) {
      this.router.navigate(['/login']);
    }
    this.init();


  }

  init() {
    this.loading = false;
    this.showInputDisease = false;
    this.showInputSymptos = false;
    this.showForPriority = false;
    this.addedSymptoms = [];
    this.sortedDiseases = [];
    this.selectedSymptom = '';
    this.nameOfSymptoms = [];
    this.nameOfIllness = [];
    this.illnessForSearch = '';
    this.medicines = [];
    this.selectedMedicines = [];
    this.allergic = [];
    this.finalIllness = '';
    this.getAllSymptoms();
    this.getAllPatients();
    this.getAllIllness();
    this.getAllMedicines();
    this.highestDisease = '';

  }

  startWithPriority() {
    const dto = new PatientSymptoms(this.addedSymptoms, this.patient);
    console.log(dto);
    this.resonerService.getWithHighestPriority(dto).subscribe(result => {
      this.highestDisease = result as string;
      this.addedSymptoms = [];
      this.selectedSymptom = '';
      this.getAllSymptoms();

    }, () => {
      return;
    });
  }

  showAllDesease() {
    const dto = new PatientSymptoms(this.addedSymptoms, this.patient);
    this.resonerService.getAllDiseaseBySymptoms(dto).subscribe(result => {
      this.sortedDiseases = result as any[];
      this.addedSymptoms = [];
      this.getAllSymptoms();

      //  console.log(this.sortedDiseases);
    }, () => {
      return;
    });
  }

  showAllSymptoms() {

    const dto = {searchValue: this.illnessForSearch};
    this.resonerService.getAllForIllness(dto).subscribe(result => {
      this.sortedDiseases = result as any[];
      console.log(result);
      this.getAllSymptoms();
      this.illnessForSearch = '';

    }, () => {
      return;
    });
  }

  checkForPatient() {
    this.patientService.findByJmbg(this.patient.jmbg).subscribe(result => {
      this.messageService.sendMessage('You have chosen a patient!');
      this.patient = result as Patient;
      this.patientChoosen = true;
    }, () => {
      this.toastr.error('Patient does not exist');
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

  searchIllness = (text$: Observable<string>) =>
    text$
      .debounceTime(200)
      .merge(this.click$.filter(() => !this.instance.isPopupOpen()))
      .map(term => term === '' ? this.nameOfIllness
        : this.nameOfIllness.filter(v => {
          return (v.toLowerCase().indexOf(term.toLowerCase()) > -1);
        }));


  addSymptom() {
    this.highestDisease = '';
    this.sortedDiseases = [];

    this.addedSymptoms.push(this.selectedSymptom);
    const index = this.nameOfSymptoms.indexOf(this.selectedSymptom);
    this.nameOfSymptoms.splice(index, 1);
    this.selectedSymptom = '';
  }

  deleteSymptom(symptom) {
    const index = this.addedSymptoms.indexOf(symptom);
    this.addedSymptoms.splice(index, 1);
    this.nameOfSymptoms.push(symptom);
  }

  valid(): boolean {
    if (this.nameOfSymptoms.some(x => x === this.selectedSymptom)) {
      return true;
    } else {
      return false;
    }
  }

  private getAllSymptoms() {
    this.nameOfSymptoms = [];
    this.symptomService.getAll().subscribe(result => {
      this.symptoms = result as Symptom[];
      for (const symptom of this.symptoms) {
        this.nameOfSymptoms.push(symptom.name);
      }
    });
  }

  private getAllIllness() {
    this.nameOfIllness = [];
    this.illnessService.getAll().subscribe(result => {
      for (const i of result as Illness[]) {
        this.nameOfIllness.push(i.name);
      }
    });
  }

  private getAllMedicines() {
    this.medicineService.getAll().subscribe(result => {
      this.medicines = result as Medicine[];
      console.log(this.medicines);
    });
  }

  onEditClick(value) {
    this.init();
    if (value === 'Show disease with the highest priority') {
      this.showForPriority = true;
      this.showInputSymptos = false;
      this.showInputDisease = false;
    } else if (value === 'Show all disease for symptoms') {
      this.showInputDisease = true;
      this.showInputSymptos = false;
      this.showForPriority = false;
    } else if (value === 'Show all symptoms for disease') {
      this.showInputSymptos = true;
      this.showForPriority = false;
      this.showInputDisease = false;
    }

  }

  private getAllPatients() {
    this.patientService.findAll().subscribe(r => {
      this.patients = r as Patient[];
    });

  }


  customSearchFn(term: string, item: Patient) {
    term = term.toLocaleLowerCase();
    return item.firstName.toLocaleLowerCase().indexOf(term) > -1 || item.lastName.toLocaleLowerCase().indexOf(term) > -1
      || item.jmbg.toLocaleLowerCase().indexOf(term) > -1;
  }


  validateMedicines() {
    this.allergic = [];
    this.medicineService.checkValidity(this.selectedMedicines, this.patient.jmbg).subscribe(r => {
      if (!(r as any[]).length) {
        this.toastr.success("The patient can take these medicines");
        return;
      }
      for (const medicine of r as any[]) {
        let message = '';
        for (const ing of medicine['value']) {
          message += ing + ', ';
        }
        this.allergic.push({key: 'allergic on: ' + medicine['key'] + ' -> ', value: message.substring(0, message.length - 2)});
      }
      console.log(this.allergic);
    });
  }

  addExamination() {
    const examination = new MedicalExamination();
    examination.doctor = SecurityUtil.getUser();
    const illness = new Illness();
    illness.name = this.finalIllness;
    examination.illness = illness;
    examination.medicines = this.selectedMedicines;
    console.log(examination);
    this.examinationService.add(examination, this.patient.jmbg).subscribe(r => {
      console.log(r);
      this.router.navigate(['/examination']);
      console.log('success');
      this.toastr.success('Examination successfully added!');

    });
  }
}
