import {Injectable} from '@angular/core';
import {InMemoryDbService} from 'angular-in-memory-web-api';
import {Project} from '../domain/project';

@Injectable({
  providedIn: 'root'
})
export class InMemoryDataService implements InMemoryDbService {

  constructor() {
  }

  createDb() {
    const projects: Project[] = [
      {
        id: 1,
        tag: 'Renaissance',
        title: 'Renaissance in Italy',
        description: 'abc',
        chapters: [{
          id: 1,
          title: 'Works of Leonardo da Vinci',
          readings: [{
            id: 1,
            title: 'Introduction',
            text: 'Despite the recent awareness and admiration of Leonardo as a scientist and inventor,' +
              'for the better part of four hundred years his fame rested on his achievements as a painter.' +
              'A handful of works that are either authenticated or attributed to him have been regarded as' +
              'among the great masterpieces. These paintings are famous for a variety of qualities that have' +
              'been much imitated by students and discussed at great length by connoisseurs and critics. By the' +
              '1490s Leonardo had already been described as a "Divine" painter.[81]\n' + '\n' + 'Among the qualities' +
              ' that make Leonardo\'s work unique are his innovative techniques for laying on the paint; his detailed knowledge' +
              ' of anatomy, light, botany and geology; his interest in physiognomy and the way humans register emotion in' +
              ' expression and gesture; his innovative use of the human form in figurative composition; and his use of' +
              ' subtle gradation of tone. All these qualities come together in his most famous painted works,' +
              ' the Mona Lisa, the Last Supper, and the Virgin of the Rocks.'
          }],
          games: [{
            id: 1,
            tasks: [
              {
                id: 1,
                question: 'What is the name of the lady behind the picture?',
                answer: 'Mona Lisa',
                imageUrl: 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Mona_Lisa%2C_by_' +
                  'Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg/402px-Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg'
              },
              {
                id: 2,
                question: 'The person in the picture is, by profession, a...',
                answer: 'musician',
                imageUrl: 'https://upload.wikimedia.org/wikipedia/commons/thumb/8/83/Leonardo_da_Vinci_' +
                  '-_Portrait_of_a_Musician.jpg/142px-Leonardo_da_Vinci_-_Portrait_of_a_Musician.jpg'
              },
              {
                id: 3,
                question: 'To which number does the painting "The Last Supper" contain references?',
                answer: 'three',
                imageUrl: 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/bb/Leonardo_da_Vinci_' +
                  '-_The_Last_Supper_high_res.jpg/180px-Leonardo_da_Vinci_-_The_Last_Supper_high_res.jpg'
              },
              {
                id: 4,
                question: 'In which Polish city is "Lady with an Ermine" kept, considered a national treasure?',
                answer: 'Krakow',
                imageUrl: 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/ed/Dama_z_gronostajem' +
                  '.jpg/145px-Dama_z_gronostajem.jpg'
              },
              {
                id: 5,
                question: 'What is the name of this painting where heavens are represented by a crystalline sphere?',
                answer: 'Salvator Mundi',
                imageUrl: 'https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Leonardo_da_Vinci' +
                  '%2C_Salvator_Mundi%2C_c.1500%2C_oil_on_walnut%2C_45.4_%C3%97_65.6_cm.jpg/136px-' +
                  'Leonardo_da_Vinci%2C_Salvator_Mundi%2C_c.1500%2C_oil_on_walnut%2C_45.4_%C3%97_65.6_cm.jpg'
              },
            ]
          }]
        }]
      }
    ];

    return { projects };
  }
}
