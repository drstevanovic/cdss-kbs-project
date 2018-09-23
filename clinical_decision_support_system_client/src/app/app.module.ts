import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {RegisterComponent} from './components/account/register/register.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {AppRoutingModule} from './app-routing.module';
import {AccountComponent} from './components/account/account.component';
import {UserService} from './service/users/user.service';
import {ToastrModule} from 'ngx-toastr';
import {MessageService} from './service/message.service';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {AngularFontAwesomeModule} from 'angular-font-awesome';
import {LoginComponent} from './components/account/login/login.component';
import {NgxPermissionsModule} from 'ngx-permissions';
import {NavbarComponent} from './components/navbar/navbar.component';
import {ExaminationComponent} from './components/examination/examination.component';
import {AddMedicinesComponent} from './components/medicines/add-medicines/add-medicines.component';
import {AddIllnessComponent} from './components/illness/add-illness/add-illness.component';
import {AddPatientComponent} from './components/patient/add-patient/add-patient.component';
import {ExaminationService} from './service/examination/examination.service';
import {IllnessService} from './service/illness/illness.service';
import {MedicineService} from './service/medicine/medicine.service';
import {PatientService} from './service/patient/patient.service';
import {ReportService} from './service/report/report.service';
import {ReportsComponent} from './components/reports/reports.component';
import {SymptomService} from './service/symptom/symptom.service';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {ResonerService} from './service/resoner/resoner.service';
import {NG_SELECT_DEFAULT_CONFIG, NgSelectModule} from '@ng-select/ng-select';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    AccountComponent,
    LoginComponent,
    NavbarComponent,
    ExaminationComponent,
    AddMedicinesComponent,
    AddIllnessComponent,
    AddPatientComponent,
    ReportsComponent,
  ],
  imports: [
    NgSelectModule,
    NgbModule.forRoot(),
    ToastrModule.forRoot({
      preventDuplicates: true,
    }),
    BrowserAnimationsModule,
    AngularFontAwesomeModule,
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    NgxPermissionsModule.forRoot(),
  ],
  providers: [UserService, MessageService, ExaminationService, IllnessService, MedicineService, PatientService,
    ReportService, SymptomService, ResonerService,
    {
      provide: NG_SELECT_DEFAULT_CONFIG,
      useValue: {
        notFoundText: 'Custom not found'
      }
    }],
  bootstrap: [AppComponent]
})
export class AppModule {
}
