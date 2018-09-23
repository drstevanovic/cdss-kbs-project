import {Component, OnInit} from '@angular/core';
import {Patient} from '../../model/patient.model';
import {ReportService} from '../../service/report/report.service';
import {MessageService} from '../../service/message.service';

@Component({
  selector: 'app-reports',
  templateUrl: './reports.component.html',
  styleUrls: ['./reports.component.css']
})
export class ReportsComponent implements OnInit {

  constructor(private reportService: ReportService, private messageService: MessageService) {
  }

  patients: Patient[];

  ngOnInit() {
    this.patients = [];
  }

  showAllChronic() {

    this.reportService.getAllChronic().subscribe(result => {
      this.patients = result as Patient[];
      console.log(this.patients);
      if (this.patients.length === 0) {
        this.messageService.sendMessage('There are no chronic patients!');
      }
    }, () => {
      return;
    });
  }

  showAllAddict() {
    this.reportService.getAllAddict().subscribe(result => {
      console.log(result);
      this.patients = result as Patient[];
      if (this.patients.length === 0) {
        this.messageService.sendMessage('There are no addict patients!');
      }
    }, () => {
      return;
    });
  }

  showAllImmunity() {

    this.reportService.getAllImmunity().subscribe(result => {
      this.patients = result as Patient[];
      if (this.patients.length === 0) {
        this.messageService.sendMessage('There are no patients with poor immunity!');
      }
    }, () => {
      return;
    });
  }

  onEditClick(value) {
    this.patients = [];
    if (value === 'Show potential chronic patients') {
      this.showAllChronic();
    } else if (value === 'Show potential addict patients') {
      this.showAllAddict();
    } else if (value === 'Show patients with poor immunity') {
      this.showAllImmunity();
    }

  }

}
