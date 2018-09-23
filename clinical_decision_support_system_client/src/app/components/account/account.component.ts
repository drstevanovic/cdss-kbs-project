import {Component, OnInit} from '@angular/core';
import {ToastrService} from 'ngx-toastr';
import {MessageService} from '../../service/message.service';
import {Router} from '@angular/router';
import {SecurityUtil} from '../../utils/security-util';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  public msg: string;

  constructor(private toastr: ToastrService, private messageService: MessageService, private router: Router) {
  }


  ngOnInit() {
    if (SecurityUtil.isEmpty()) {
      this.router.navigate(['/login']);
    }

  }


}
