import {Component} from '@angular/core';
import {MessageService} from './service/message.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  private serverUrl = 'http://localhost:8090/socket';

}
