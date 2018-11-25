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
  MatListModule, MatProgressBarModule, MatSnackBarModule,
  MatToolbarModule,
} from '@angular/material';
import {HttpClientModule} from '@angular/common/http';
import {HttpClientInMemoryWebApiModule} from 'angular-in-memory-web-api';
import {InMemoryDataService} from './service/in-memory-data.service';
import { ProjectListComponent } from './component/project-list/project-list.component';
import { ProjectComponent } from './component/project/project.component';
import { ChapterInfoComponent } from './component/project/chapter-info/chapter-info.component';
import { ReadingComponent } from './component/project/reading/reading.component';
import { GameComponent } from './component/project/game/game.component';
import { ChapterHeaderComponent } from './component/project/chapter-header/chapter-header.component';
import { TeacherComponent } from './component/teacher/teacher.component';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSelectModule} from '@angular/material/select';
import {MatCardModule} from '@angular/material/card';
import { ChapterEditionComponent } from './component/chapter-edition/chapter-edition.component';
import { QuestionComponent } from './component/question/question.component';
import { FormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    ProjectListComponent,
    ProjectComponent,
    ChapterInfoComponent,
    ReadingComponent,
    GameComponent,
    ChapterHeaderComponent,
    ProjectComponent,
    TeacherComponent,
    ChapterEditionComponent,
    QuestionComponent
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
    MatChipsModule,
    MatDividerModule,
    MatFormFieldModule,
    MatSelectModule,
    MatCardModule,
    MatProgressBarModule,
    MatSnackBarModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
