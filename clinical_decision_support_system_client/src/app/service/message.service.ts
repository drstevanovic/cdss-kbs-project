import {Injectable} from '@angular/core';
import {BehaviorSubject} from 'rxjs/internal/BehaviorSubject';
import {ToastrService} from "ngx-toastr";

@Injectable({
  providedIn: 'root'
})
export class MessageService {
  private messageSource = new BehaviorSubject<string>('');
  currentMessage = this.messageSource.asObservable();

  constructor(private toastr: ToastrService) {
  }

  sendMessage(msg: string) {
    this.toastr.info(msg);
    this.messageSource.next(msg);
  }
}
