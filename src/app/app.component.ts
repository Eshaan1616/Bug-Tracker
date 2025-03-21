import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { NavigationEnd, Router, RouterLink, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RouterLink, CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {


  title = 'assistanz';
  routerUrl: string = "";
  isLoggedIn: boolean = false;

  constructor( private _router: Router)  {
 
  }

  ngOnInit() {
    this._router.events.subscribe((e) => {
      if (e instanceof NavigationEnd) {
        this.routerUrl = e.url;
        if(this.routerUrl !== '/' && this.routerUrl !== '/login-a') {
          this.isLoggedIn = true;
        } else {
          this.isLoggedIn = false;
        }
      }
    });
  }

  
}