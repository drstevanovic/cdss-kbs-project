import {MedicalExamination} from './medical-examination.model';
import {Symptom} from './symptom.model';

export class Illness {

  constructor(public id?: number,
              public name?: string,
              public symptoms?: Symptom[]
     ) {
      this.symptoms = [];
  }
}
