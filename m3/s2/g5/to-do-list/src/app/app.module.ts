import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './main-components/header/header.component';
import { HomepageComponent } from './pages/homepage/homepage.component';
import { CompletedComponent } from './pages/completed/completed.component';
import { IncompleteComponent } from './pages/incomplete/incomplete.component';
import { UsersComponent } from './pages/users/users.component';
import { FooterComponent } from './main-components/footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomepageComponent,
    CompletedComponent,
    IncompleteComponent,
    UsersComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
