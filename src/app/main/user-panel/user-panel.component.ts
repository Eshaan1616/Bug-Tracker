import { Component,OnInit, TemplateRef, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';


@Component({
  selector: 'app-user-panel',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './user-panel.component.html',
  styleUrl: './user-panel.component.scss' 
})
export class UserPanelComponent implements OnInit {
  private modalService = inject(NgbModal);
  users: any = [];
  newUser: any = {};
  // userInfo:any = {};
  modalReference:any;
  enableEdit: boolean = false;

  constructor(private _http: HttpClient) {}

  ngOnInit(): void {
    this.userData();
    this.loadUsers();
  }


  userData() {
    this._http.get('http://192.168.4.115:8081/api/user').subscribe((response) => {
      this.users = response;
    })
  }

  loadUsers(): void {
    this._http.get<any[]>('http://192.168.4.115:8081/api/user').subscribe(
      users => {
        this.users = users;
      },
      error => {
        console.error('Error loading users:', error);
      }
    );
  }

  submitUserForm(): void {
    // Handle form submission logic here
    console.log('Submitted user:', this.newUser);
    if(this.enableEdit) {
      this.editUser();
    } else {
      this.addUser();
    }
  
    // Assuming you have a backend endpoint to handle new bug creation

  }

  addUser(): void {
    this._http.post('http://192.168.4.115:8081/api/user', this.newUser).subscribe(
      response => {
        console.log('User created successfully:', response);
        // Clear form and close modal after successful submission
        this.newUser = {};
        // Reload bugs data
        this.loadUsers();
        // Close modal
        this.modalReference?.close();
      },
      error => {
        console.error('Error creating user:', error);
      }
    );
  }

  editUser(): void {
    this._http.put(`http://192.168.4.115:8081/api/user/${this.newUser.id}`, this.newUser).subscribe(
      response => {
        console.log('User created successfully:', response);
        // Clear form and close modal after successful submission
        this.newUser = {};
        // Reload bugs data
        this.loadUsers();
        // Close modal
        this.modalReference?.close();
      },
      error => {
        console.error('Error creating user:', error);
      }
    );
  }

  getuserDetails(id: number, content: TemplateRef<any>) {
    this._http.get(`http://192.168.4.115:8081/api/user/${id}`).subscribe((response) => {
      console.log(' Update successful', response);
      this.newUser = response;
      this.enableEdit = true;
      this.openVerticallyCentered(content);
    }, err => {

    }
  )}


  

  deleteUser(id: number) {
    this._http.delete(`http://192.168.4.115:8081/api/user/${id}`).subscribe((response) => {
        console.log('Delete successful', response);
        // Refresh the user data
        this.userData();
      }, err => {
        console.error('Error deleting user', err);
      }
    )}

    openVerticallyCentered(content: TemplateRef<any>) {
     this.modalReference =  this.modalService.open(content, { centered: true });
    }

    close(): void {
      this.modalReference?.close();
      this.newUser = {};
    }

  }





// import { Component, OnInit } from '@angular/core';
// import { HttpClient } from '@angular/common/http';
// import { CommonModule } from '@angular/common';

// @Component({
//   selector: 'app-user-panel',
//   standalone: true,
//   imports: [CommonModule],
//   templateUrl: './user-panel.component.html',
//   // Fixed typo from styleUrl to styleUrls
//   styleUrls: ['./user-panel.component.scss'] 
// })
// export class UserPanelComponent implements OnInit {
//   users: any = [];

//   constructor(private _http: HttpClient) {}

//   ngOnInit(): void {
//     this.userData();
//   }

//   userData() {
//     this._http.get('http://192.168.4.190:8081/api/user').subscribe((response) => {
//       this.users = response;
//     });
//   }

//   // Added deleteUser method
//   deleteUser(id: number) {
//     this._http.delete(`http://192.168.4.190:8081/api/user/${id}`).subscribe({
//       next: (response) => {
//         console.log('Delete successful', response);
//         // Refresh the user data
//         this.userData();
//       },
//       error: (error) => {
//         console.error('Error deleting user', error);
//       }
//     });
//   }
// }
