
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, map } from 'rxjs';
import { Game } from '../models/game';

@Injectable({
  providedIn: 'root',
})
export class GameService {
  private apiUrl = 'assets/api.json';

  constructor(private http: HttpClient) {}

  getGames(): Observable<Game[]> {
    return this.http.get<{ games: Game[] }>(this.apiUrl).pipe(
      map((response) => response.games)
    );
  }

  getGameById(id: number): Observable<Game | undefined> {
    return this.http.get<{ games: Game[] }>(this.apiUrl).pipe(
      map((response) => response.games.find((game) => game.id === id))
    );
  }
}