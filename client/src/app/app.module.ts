import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {
  MatBadgeModule,
  MatButtonModule, MatChipsModule,
  MatDividerModule, MatExpansionModule,
  MatIcon,
  MatIconModule,
  MatListModule,
  MatToolbarModule
} from '@angular/material';
import {StudentService} from './service/student.service';
import {HttpClientModule} from '@angular/common/http';
import {HttpClientInMemoryWebApiModule} from 'angular-in-memory-web-api';
import {InMemoryDataService} from './service/in-memory-data.service';
import { ProjectListComponent } from './component/project-list/project-list.component';
import { ProjectComponent } from './component/project/project.component';
import { ChapterInfoComponent } from './component/project/chapter-info/chapter-info.component';

@NgModule({
  declarations: [
    AppComponent,
    ProjectListComponent,
    ProjectComponent,
    ChapterInfoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    HttpClientInMemoryWebApiModule.forRoot(
      InMemoryDataService, { dataEncapsulation: false}
    ),
    MatButtonModule,
    MatToolbarModule,
    MatIconModule,
    MatListModule,
    MatBadgeModule,
    MatDividerModule,
    MatExpansionModule,
    MatChipsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
