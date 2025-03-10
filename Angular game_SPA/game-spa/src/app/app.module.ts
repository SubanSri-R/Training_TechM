import { NgModule } from '@angular/core';
import { BrowserModule} from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { GameCardComponent } from './components/game-card/game-card.component';
import { GameDetailsComponent } from './components/game-details/game-details.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { FilterPipe } from './pipes/filter.pipe';
import { HttpClientModule,provideHttpClient,withFetch } from '@angular/common/http';
import { AuthService } from './services/auth.service';
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    GameCardComponent,
    GameDetailsComponent,
    LoginComponent,
    HomeComponent,
    FilterPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    provideHttpClient(withFetch()),
    AuthService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
