import {Component, OnInit} from '@angular/core';
import {User} from '../../../model/user.model';
import {UserService} from '../../../service/users/user.service';
import {xml2json} from 'xml2json-light';
import {MessageService} from '../../../service/message.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-register-component',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  user: User;

  values = ['ADMIN', 'DOCTOR'];

  constructor(private userService: UserService, private messageService: MessageService, private router: Router) {
    this.user = new User();

  }

  ngOnInit() {

  }

  registerUser() {
    this.userService.register(this.user).subscribe(() => {
      this.messageService.sendMessage('Successfully registration.');
      this.router.navigate(['/account']);
    });
  }
}
