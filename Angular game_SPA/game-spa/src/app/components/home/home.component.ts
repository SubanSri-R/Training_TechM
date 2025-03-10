
import { Component, OnInit } from '@angular/core';
import { GameService } from '../../services/game.service';
import { Router } from '@angular/router';
import { Game } from '../../models/game';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {
  games: Game[] = [];
  searchText:string = '';
  constructor(private gameService: GameService, private router: Router) {}

  ngOnInit(): void {
    this.gameService.getGames().subscribe((data) => (this.games = data));
  }
  onGameClick(gameId: number): void {
    this.router.navigate(['/games', gameId]);
  }
}