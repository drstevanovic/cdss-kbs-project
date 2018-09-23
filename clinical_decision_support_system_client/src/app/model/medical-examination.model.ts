import {User} from './user.model';
import {Medicine} from './medicine.model';
import {Illness} from './illness.model';

export class MedicalExamination {


constructor(public id?: number,
              public date?: Date,
              public illness?: Illness,
              public doctor?: User,
              public medicines?: Medicine[]
) {

  }
}
