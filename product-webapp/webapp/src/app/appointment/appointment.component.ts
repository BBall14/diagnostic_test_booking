import { Component, OnInit } from '@angular/core';
import { DiagnosticService } from '../service/diagnostic.service';

@Component({
  selector: 'app-appointment',
  templateUrl: './appointment.component.html',
  styleUrls: ['./appointment.component.css']
})
export class AppointmentComponent implements OnInit {

  // declare appointmentList variable
  appointmentList: any;

  constructor(private service: DiagnosticService) { }

  // call get all api and display in table
  ngOnInit(): void {
    this.service.getAllAppointment().subscribe((data) => {
      this.appointmentList = data;
      console.log(this.appointmentList);
    }
    );
  }

  // call post api and add to list
  modify(appointment: any) {
    appointment.date = '2023-07-03 09:30'
    this.service.updateAppointment(appointment).subscribe((data) => {
      console.log(data);
    }
    );
  }

  // call delete api and remove from list
  remove(id: any) {
    this.service.deleteAppointment(id).subscribe((data) => {
      console.log(data);
    }
    );
  }

}
