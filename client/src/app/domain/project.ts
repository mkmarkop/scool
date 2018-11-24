import {Chapter} from './chapter';

export class Project {
  id: number;
  title: string;
  description: string;
  tag: string;
  chapters: Chapter[];
}
