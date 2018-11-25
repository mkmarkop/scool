import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {
  MatBadgeModule,
  MatButtonModule,
  MatDividerModule,
  MatIcon,
  MatIconModule,
  MatListModule,
  MatToolbarModule,
} from '@angular/material';
import {MatExpansionModule} from '@angular/material/expansion';
import {StudentService} from './service/student.service';
import {HttpClientModule} from '@angular/common/http';
import {HttpClientInMemoryWebApiModule, HttpInMemoryWebApiModule} from 'angular-in-memory-web-api';
import {InMemoryDataService} from './service/in-memory-data.service';
import { ProjectListComponent } from './component/project-list/project-list.component';
import { ProjectComponent } from './component/project/project.component';
import { TeacherComponent } from './component/teacher/teacher.component';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSelectModule} from '@angular/material/select';
import {MatCardModule} from '@angular/material/card';
import { ChapterEditionComponent } from './component/chapter-edition/chapter-edition.component';

@NgModule({
  declarations: [
    AppComponent,
    ProjectListComponent,
    ProjectComponent,
    TeacherComponent,
    ChapterEditionComponent
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
    MatFormFieldModule,
    MatSelectModule,
    MatCardModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
