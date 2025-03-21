// src/app/app.module.ts

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {provideHttpClient } from '@angular/common/http';
import { AppComponent } from './app.component';
import { CommonModule } from '@angular/common';
import { UserPanelComponent } from './main/user-panel/user-panel.component';


@NgModule({
  declarations: [
    AppComponent,
    UserPanelComponent
  ],
  imports: [
    BrowserModule,
    CommonModule
  ],
  providers: [provideHttpClient()],
  bootstrap: [AppComponent]
})
export class AppModule { }
