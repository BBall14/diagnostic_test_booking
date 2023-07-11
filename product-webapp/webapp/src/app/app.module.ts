import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { TestComponent } from './test/test.component';
import { AppointmentComponent } from './appointment/appointment.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
// import matbutton module
import { MatButtonModule } from '@angular/material/button';
// import flexlayout module
import { FlexLayoutModule } from '@angular/flex-layout';
// import matcard module
import { MatCardModule } from '@angular/material/card';
// import HttpClientModule to make http requests
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
// Import formsmodule
import { FormsModule } from '@angular/forms';
import { ToolbarComponent } from './toolbar/toolbar.component';
import { RegisterComponent } from './register/register.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    TestComponent,
    AppointmentComponent,
    ToolbarComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    // MatButtonModule to display buttons
    MatButtonModule,
    // FlexLayoutModule to display in flex layout
    FlexLayoutModule,
    // MatCardModule to dispaly cards
    MatCardModule,
    // HttpClientModule to make http requests
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
