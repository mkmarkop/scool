import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material';
import {StudentService} from './service/student.service';
import {HttpClientModule} from '@angular/common/http';
import { StudentListComponent } from './component/student-list/student-list.component';
import {HttpInMemoryWebApiModule} from 'angular-in-memory-web-api';
import {InMemoryDataService} from './service/in-memory-data.service';
import { ProjectListComponent } from './component/project-list/project-list.component';

@NgModule({
  declarations: [
    AppComponent,
    StudentListComponent,
    ProjectListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    HttpClientModule,
    HttpInMemoryWebApiModule.forRoot(
      InMemoryDataService, { dataEncapsulation: false}
    )
  ],
  providers: [StudentService],
  bootstrap: [AppComponent]
})
export class AppModule { }
