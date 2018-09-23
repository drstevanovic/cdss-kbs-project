import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {RegisterComponent} from './components/account/register/register.component';
import {AccountComponent} from './components/account/account.component';
import {LoginComponent} from './components/account/login/login.component';
import {ExaminationComponent} from './components/examination/examination.component';
import {ReportsComponent} from './components/reports/reports.component';
import {AddIllnessComponent} from './components/illness/add-illness/add-illness.component';
import {AddPatientComponent} from './components/patient/add-patient/add-patient.component';
import {AddMedicinesComponent} from './components/medicines/add-medicines/add-medicines.component';



const appRoutes: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'account', component: AccountComponent},
  {path: 'login', component: LoginComponent},
  {path: 'new-user', component: RegisterComponent},
  {path: 'examination', component: ExaminationComponent},
  {path: 'reports', component: ReportsComponent},
  {path: 'new-disease', component: AddIllnessComponent},
  {path: 'new-patient', component: AddPatientComponent},
  {path: 'new-medicine', component: AddMedicinesComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})

export class AppRoutingModule {
}
