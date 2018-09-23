import {MedicalExamination} from './medical-examination.model';

export class Patient {

  constructor(public id?: number,
              public firstName?: string,
              public lastName?: string,
              public jmbg?: string,
              public allergicIngredients?: string[],
              public examinations?: MedicalExamination,
     ) {

  }

}
