import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProjectListComponent} from './component/project-list/project-list.component';
import {ProjectComponent} from './component/project/project.component';
import {ReadingComponent} from './component/project/reading/reading.component';
import {GameComponent} from './component/project/game/game.component';

const routes: Routes = [
  { path: '', redirectTo: '/projects', pathMatch: 'full' },
  { path: 'projects', component: ProjectListComponent },
  { path: 'project/:id', component: ProjectComponent },
  { path: 'reading/:id', component: ReadingComponent },
  { path: 'assignment/:id', component: GameComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
