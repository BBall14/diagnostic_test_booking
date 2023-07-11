import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css']
})
export class ToolbarComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  // method to navigate to test component
  returnTest(){
    this.router.navigate(['/test']);
  }

  // method to navigate to appointment component
  appointment(){
    this.router.navigate(['/appointment']);
  }

}
