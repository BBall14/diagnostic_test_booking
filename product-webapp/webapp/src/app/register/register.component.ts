import { Component, OnInit } from '@angular/core';
import { DiagnosticService } from '../service/diagnostic.service';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  // declare username and password variables
  username!: string;
  password!: string;
  // declare errorMessage variable
  errorMessage!: string;
  
  constructor(private service: DiagnosticService, private router: Router) { }

  ngOnInit(): void {
  }

  // call register api and navigate to login page
  register() {

    this.service.register(this.username, this.password).subscribe((data) => {
      console.log(data);
      this.router.navigate(['/login']);
    },
    // if error occurs, display error message
    (error: HttpErrorResponse) => {
      if (error.status === 409) {
        this.errorMessage = 'Invalid';
      } else {
        this.errorMessage = 'An error occurred. Please try again later.';
      }
    }
  );
  }

}
