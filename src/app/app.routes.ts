import { Routes } from '@angular/router';
import { DashboardComponent } from './main/dashboard/dashboard.component';
import { UserPanelComponent } from './main/user-panel/user-panel.component';
import { BugPanelComponent } from './main/bug-panel/bug-panel.component';
import { LoginAComponent } from './login-a/login-a.component';


export const routes: Routes = [
    {   path: '', redirectTo: '/login-a', pathMatch: 'full'
    },
   
    {
        path: 'login-a', component: LoginAComponent
    },
    {
        path: 'dashboard', component: DashboardComponent
    },
    {
        path: 'user-panel', component: UserPanelComponent
    },
   
    {
        path: 'bug-panel', component: BugPanelComponent
        
    }
];
