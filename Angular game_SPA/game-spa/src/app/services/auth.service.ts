
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable, of } from 'rxjs';
import { map } from 'rxjs/operators';
import { User } from '../models/user'; 

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private apiUrl = 'assets/api.json';
  private usersKey = 'game-spa-users'; 
  private currentUserSubject: BehaviorSubject<User | null>;

  constructor(private http: HttpClient) {
   
    if (!localStorage.getItem(this.usersKey)) {
      this.getUsersFromApi().subscribe((users) => {
        localStorage.setItem(this.usersKey, JSON.stringify(users));
      });
    }


    const currentUserJson = localStorage.getItem('currentUser');
    const currentUser = currentUserJson ? JSON.parse(currentUserJson) : null;
    this.currentUserSubject = new BehaviorSubject<User | null>(currentUser);
  }


  get currentUser$(): Observable<User | null> {
    return this.currentUserSubject.asObservable();
  }


  getCurrentUser(): User | null {
    return this.currentUserSubject.value;
  }

  private getUsersFromApi(): Observable<User[]> {
    return this.http.get<{ users: User[] }>(this.apiUrl).pipe(
      map((response) => response.users)
    );
  }

  private getUsersFromLocalStorage(): User[] {
    const usersJson = localStorage.getItem(this.usersKey);
    return usersJson ? JSON.parse(usersJson) : [];
  }


  addUser(user: User): Observable<User> {
    const users = this.getUsersFromLocalStorage();
    users.push(user); 
    localStorage.setItem(this.usersKey, JSON.stringify(users));
    return of(user); 
  }


  login(email: string, password: string): Observable<User | null> {
    const users = this.getUsersFromLocalStorage();
    const user = users.find((u) => u.email === email && u.password === password);
    if (user) {
      this.currentUserSubject.next(user); 
      localStorage.setItem('currentUser', JSON.stringify(user)); 
      return of(user);
    }
    return of(null); 
  }


  logout(): void {
    this.currentUserSubject.next(null); 
    localStorage.removeItem('currentUser'); 
  }
}