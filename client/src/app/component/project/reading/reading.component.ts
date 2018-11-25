import {Component, OnInit} from '@angular/core';
import {ProjectService} from '../../../service/project.service';
import {ActivatedRoute} from '@angular/router';
import {Reading} from '../../../domain/reading';
import {ReadingService} from '../../../service/reading.service';

@Component({
  selector: 'app-reading',
  templateUrl: './reading.component.html',
  styleUrls: ['./reading.component.css']
})
export class ReadingComponent implements OnInit {

  private reading: Reading;

  constructor(
    private readingService: ReadingService,
    private route: ActivatedRoute
  ) {

  }

  ngOnInit() {
    const id = +this.route.snapshot.paramMap.get('id');
    this.readingService.getReading(id).subscribe(
      reading => {
        this.reading = reading;
      }
    );
  }

}
