import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {GameService} from '../../../service/game.service';
import {Location} from '@angular/common';
import {Game} from '../../../domain/game';
import {Task} from '../../../domain/task';
import {MatSnackBar} from '@angular/material';
import {config} from 'rxjs';

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css']
})
export class GameComponent implements OnInit {

  private game: Game;
  private task: Task;
  private taskIndex = 0;
  private correct = 0;
  private finished = false;
  private percentage = 0;
  private streak = 0;

  @ViewChild('taskQuestion') questionRef: ElementRef;

  constructor(
    private route: ActivatedRoute,
    private gameService: GameService,
    private snackBar: MatSnackBar,
    private location: Location
  ) {
  }

  ngOnInit() {
    const id = +this.route.snapshot.paramMap.get('id');
    this.gameService.getGame(id).subscribe(
      game => {
        this.game = game;
        this.nextTask();
      }
    );
  }

  finishGame(): void {
    this.finished = true;
    this.percentage = this.correct / this.game.tasks.length;
    return;
  }

  nextTask(): void {
    if (this.taskIndex === this.game.tasks.length) {
      return this.finishGame();
    }

    this.task = this.game.tasks[this.taskIndex++ % this.game.tasks.length];
  }

  displayInfo(message: string) {
    this.snackBar.open(message, undefined, {
      duration: 500
    });
  }

  onAnswerSubmit(answer: Event) {
    if (answer.toString() === this.task.answer) {
      this.correct++;
      this.streak++;

      if (this.streak === 3) {
        this.displayInfo('Three in a row! Good start!');
      } else if (this.streak === 4) {
        this.displayInfo('Quattro Formaggio! Go on!');
      } else if (this.streak === 5) {
        this.displayInfo('Perfect score! Are you Da Vinci\'s relative?');
      }
    } else {
      this.displayInfo('Unfortunately no :(');
    }

    this.nextTask();
  }

  reset() {
    this.task = undefined;
    this.taskIndex = 0;
    this.correct = 0;
    this.finished = false;
    this.percentage = 0;
    this.streak = 0;
    this.nextTask();
  }

}
