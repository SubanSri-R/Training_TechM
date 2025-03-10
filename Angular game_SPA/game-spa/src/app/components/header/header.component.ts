

import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service'; 
import { Router } from '@angular/router';
import { User } from '../../models/user';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent implements OnInit {
  currentUser: User | null = null;

  constructor(public authService: AuthService, private router: Router) {}

  ngOnInit(): void {
    // Subscribe to the current user observable
    this.authService.currentUser$.subscribe((user) => {
      this.currentUser = user;
    });
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/login']); // Redirect to login page
  }
}