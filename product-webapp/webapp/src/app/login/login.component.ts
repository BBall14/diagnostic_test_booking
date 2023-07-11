import { Component, OnInit } from '@angular/core';
import { DiagnosticService } from '../service/diagnostic.service';
import { HttpErrorResponse } from '@angular/common/http';
import { SecurityService } from '../service/security.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  // declare username and password variables
  username!: string;
  password!: string;
  // declare errorMessage variable
  errorMessage!: string;
  
  // inject DiagnosticService, SecurityService and Router
  constructor(private service: DiagnosticService, private security: SecurityService, private router: Router) { }

  ngOnInit(): void {
  }

  // call login api and update token
  login() {

    this.service.login(this.username, this.password).subscribe((data) => {
      console.log(data);
      this.security.updateToken(data.token, data.id);
      this.router.navigate(['/test']);
    },
    // if error occurs, display error message
    // if error status is 409, display invalid credentials
    // else display an error occurred. Please try again later.
    (error: HttpErrorResponse) => {
      if (error.status === 409) {
        this.errorMessage = 'Invalid credentials';
      } else {
        this.errorMessage = 'An error occurred. Please try again later.';
      }
    }
  );
  }
}
