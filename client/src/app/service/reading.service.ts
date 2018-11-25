import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Reading} from '../domain/reading';

@Injectable({
  providedIn: 'root'
})
export class ReadingService {

  private readingsUrl = 'api/readings';

  constructor(private http: HttpClient) { }

  getReading(id: number): Observable<Reading> {
    const url = `${this.readingsUrl}/${id}`;
    return this.http.get<Reading>(url);
  }
}
