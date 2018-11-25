import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Game} from '../domain/game';

@Injectable({
  providedIn: 'root'
})
export class GameService {

  private gamesUrl = 'api/games';

  constructor(private http: HttpClient) { }

  getGame(id: number): Observable<Game> {
    const url = `${this.gamesUrl}/${id}`;
    return this.http.get<Game>(url);
  }
}
