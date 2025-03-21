


import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, UntypedFormGroup, Validators } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-login-a',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './login-a.component.html',
  styleUrl: './login-a.component.scss'
})
export class LoginAComponent {

  FSignIn!: FormGroup ;

  

  constructor(private _http: HttpClient, private _fb: FormBuilder, private router: Router,) { }

  ngOnInit(): void {
   this.FSignIn =  this.formInit();
  }

  formInit(): UntypedFormGroup {
    return this._fb.group({
      'uname': ['', Validators.required],
      'psw': ['', Validators.required],
    })

  }

 
  getvalidateLogin() {
    const username = this.FSignIn?.value.uname;
    const password = this.FSignIn?.value.psw;
  
    this._http.get(`http://192.168.4.115:8081/api/user/get-Login-authentication`, {
      params: {
        username: username,
        password: password
      }
    }).subscribe({
      next: (response: any) => {
        console.log('Response:', response);  // Debugging line to check the response
        // Check if the response is not empty and contains the expected properties
        if (response.id !== null && response.username !== null && response.email !== null) {
          this.router.navigate(['/dashboard']);
        }  else {
          alert('Invalid username or password');
        }
      },
      error: (error) => {
        alert('Error occurred during login');
        console.error(error);
      }
    });
  }
  
  
  
  
}
