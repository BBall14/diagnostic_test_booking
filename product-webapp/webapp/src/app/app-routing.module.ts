import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TestComponent } from './test/test.component';
import { AppointmentComponent } from './appointment/appointment.component';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './service/auth.guard';
import { RegisterComponent } from './register/register.component';

// Create routes for the components
// canActivate: [AuthGuard] is used to protect the route
// if path is empty, redirect to login page
// if path is login, redirect to login page
// if path is register, redirect to register page
// if path is test, redirect to test page
// if path is appointment, redirect to appointment page
const routes: Routes = [
  {path: '', component: LoginComponent, pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'test', component: TestComponent, canActivate: [AuthGuard]},
  {path: 'appointment', component: AppointmentComponent, canActivate: [AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
