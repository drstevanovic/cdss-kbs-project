import {Component, OnInit} from '@angular/core';
import {UserService} from '../../../service/users/user.service';
import {ToastrService} from 'ngx-toastr';
import {MessageService} from '../../../service/message.service';
import {Router} from '@angular/router';
import {xml2json} from 'xml2json-light';
import {NgxPermissionsService} from 'ngx-permissions';
import {SecurityUtil} from '../../../utils/security-util';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  public username: string;
  public password: string;

  constructor(private userService: UserService, private toastr: ToastrService,
              private messageService: MessageService, private router: Router,
              private permissionsService: NgxPermissionsService) {
    this.username = '';
    this.password = '';
  }

  ngOnInit() {
  }


  login() {
    console.log(this.username + ',' + this.password);
    const user = {'username': this.username, 'password': this.password};
    this.userService.login(user).subscribe(result => {
      this.toastr.success('You have successfully logged in!');
      localStorage.setItem('loggedUser', JSON.stringify(result));
      if (SecurityUtil.getRole() === 'ADMIN') {
        this.router.navigate(['/account']);
      } else {
        this.router.navigate(['/examination']);
      }
    }, () => {
      this.toastr.error('Invalid username or password.Try again!');
      return;
    });
  }
}
