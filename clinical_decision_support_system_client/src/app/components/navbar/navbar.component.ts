import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {UserService} from '../../service/users/user.service';
import {NgxPermissionsService} from 'ngx-permissions';
import {SecurityUtil} from '../../utils/security-util';
import {MessageService} from '../../service/message.service';

const parseString = require('xml2js').parseString;

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  public isLoggedUser: boolean;
  public submittedSize: number;
  public query: string;

  constructor(private router: Router, private userService: UserService, private permissionsService: NgxPermissionsService,
              private messageService: MessageService) {
    this.isLoggedUser = this.userService.isLoggedIn();
  }

  ngOnInit() {
    const perm = [];

    const role = SecurityUtil.getRole();
    perm.push(role);
    this.permissionsService.loadPermissions(perm);
    this.permissionsService.permissions$.subscribe((permisios) => {
    });
    console.log(this.permissionsService.getPermissions());

  }

  logout() {
    this.userService.logout(SecurityUtil.getId()).subscribe(res => {
      SecurityUtil.clearLocalStorage();
      this.router.navigate(['/login']);
    });

  }

}
