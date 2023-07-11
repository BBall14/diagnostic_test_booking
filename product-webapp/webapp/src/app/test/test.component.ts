import { Component, OnInit } from '@angular/core';
import { DiagnosticService } from '../service/diagnostic.service';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {

  // Declare variable for test details
  testDetails: any;

  // variable to store test id
  testId!: string;

  // inject DiagnosticService
  constructor(private service: DiagnosticService) { }

  // call get all api and display in table
  ngOnInit(): void {
    this.service.getAllDiagnostic().subscribe((data) => {
      this.testDetails = data;
      console.log(this.testDetails);
    });
  }

  // call post api and add to list
  book(id: any) {
    // create an appointment object with patientId, testId and date
    const appointment = {
      patientId: localStorage.getItem('pId'),
      testId: id,
      date: '2023-07-03 09:00'
    };
    // call create api
    this.service.createAppointment(appointment).subscribe((data) => {
      console.log(data);
    }
    );
  }

  // getTest() method to get test details by id
  getTest(){
    // call get api
    this.service.getDiagnosticById(this.testId).subscribe((data) => {
      this.testDetails = data;
      console.log(this.testDetails);
    });
  }

}
