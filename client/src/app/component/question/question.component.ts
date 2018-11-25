import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
})
export class QuestionComponent implements OnInit {

  @Input() question: string;
  @Input() imageUrl: string;
  userAnswer = '';

  @Output() submitAnswer = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  onSubmit() {
    this.submitAnswer.emit(this.userAnswer);
    this.userAnswer = '';
  }

}
