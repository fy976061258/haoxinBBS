import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {CommonModule} from '@angular/common'

import { Index } from './index/index';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';//动画
import {MatButtonModule, MatCheckboxModule} from '@angular/material';//组件

@NgModule({
  imports: [
    BrowserModule,
    CommonModule,
    BrowserAnimationsModule,
    MatButtonModule, MatCheckboxModule
  ],
  declarations: [
    Index
  ],
  providers: [],
  bootstrap: [Index]
})
export class AppModule { }
