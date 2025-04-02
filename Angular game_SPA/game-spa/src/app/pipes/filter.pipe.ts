
import { Pipe, PipeTransform } from '@angular/core';
import { Game } from '../models/game';

@Pipe({
  name: 'filter',
})
export class FilterPipe implements PipeTransform {
  transform(games: Game[], searchText: string): Game[] {
    if (!games || !searchText) {
      return games;
    }
    return games.filter((game) =>
      game.name.toLowerCase().includes(searchText.toLowerCase())
    );
  }
}