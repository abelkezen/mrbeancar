import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule,HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FlexLayoutModule } from "@angular/flex-layout";
import { MatToolbarModule, MatIconModule, MatSidenavModule, MatListModule, MatButtonModule, MatDialog, MatDialogModule,MatSortModule } from  '@angular/material';
import { AngularMaterialModule } from './angular-material.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TableComponent } from './component/table/table.component';
import { ModalComponentComponent } from './component/modal-component/modal-component.component';

@NgModule({
  declarations: [
    AppComponent,
    TableComponent,
    ModalComponentComponent
  ],
  imports: [
    BrowserAnimationsModule,
    HttpClientModule,
    AngularMaterialModule,
    BrowserModule,
    AppRoutingModule,
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    FlexLayoutModule,
    MatToolbarModule,
    MatSidenavModule,
    MatListModule,
    MatButtonModule,
    MatIconModule,
    MatDialogModule,
    BrowserModule,
    MatSortModule
  ],
  entryComponents: [
    ModalComponentComponent
  ],
  providers: [],
  bootstrap: [AppComponent],
  
})
export class AppModule { }
