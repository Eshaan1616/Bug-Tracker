// src/app/user-panel/user-panel.module.ts (if using a separate module for UserPanelComponent)

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserPanelComponent } from './user-panel.component';


@NgModule({
  declarations: [
    UserPanelComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    UserPanelComponent
  ]
})
export class UserPanelModule { }
