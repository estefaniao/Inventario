import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { MercanciaComponent } from './mercancia/mercancia.component';
import { ProductoService } from './mercancia/producto.service';
import {HttpClientModule } from '@angular/common/http';
import { FormComponent } from './mercancia/form.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    MercanciaComponent,
    FormComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [ProductoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
