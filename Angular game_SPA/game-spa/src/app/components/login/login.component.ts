import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth.service'; 
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {
  loginForm: FormGroup;
  signUpForm: FormGroup;

  showSignUp = false;
  showSuccessMessage = false;
  successMessage = '';
  currentUser: any = null;

  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private router: Router
  ) {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]],
    });

    this.signUpForm = this.fb.group({
      name: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]],
    });

  
    this.currentUser = this.authService.getCurrentUser();
  }

  toggleSignUp() {
    this.showSignUp = !this.showSignUp;
  }

  onLoginSubmit() {
    if (this.loginForm.valid) {
      const email = this.loginForm.value.email;
      const password = this.loginForm.value.password;
      this.authService.login(email, password).subscribe((user) => {
        if (user) {
          this.currentUser = user;
          this.showSuccessMessage = true;
          this.successMessage = 'Login successful! Welcome back, ' + user.name + '!';
          setTimeout(() => {
            this.showSuccessMessage = false;
          }, 3000);
        } else {
          this.showSuccessMessage = true;
          this.successMessage = 'Login failed: Invalid credentials';
          setTimeout(() => {
            this.showSuccessMessage = false;
          }, 3000);
        }
      });
    }
  }

  onSignUpSubmit() {
    if (this.signUpForm.valid) {
      const newUser = this.signUpForm.value;
      this.authService.addUser(newUser).subscribe((user) => {
        this.showSuccessMessage = true;
        this.successMessage = 'Sign up successful! Welcome, ' + user.name + '!';
        this.signUpForm.reset();
        setTimeout(() => {
          this.showSuccessMessage = false;
        }, 3000);
      });
    }
  }

  logout() {
    this.authService.logout();
    this.currentUser = null;
    this.router.navigate(['/login']); 
  }
}