import {Game} from './game';
import {Reading} from './reading';

export class Chapter {
  id: number;
  title: string;
  games: Game[];
  readings: Reading[];
}
