import {Patient} from './patient.model';

export class PatientSymptoms {

  constructor(public symptoms?: string[],
              public patient?: Patient) {

  }
}
