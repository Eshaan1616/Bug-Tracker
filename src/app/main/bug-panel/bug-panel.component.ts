import { Component,OnInit, TemplateRef, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-bug-panel',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './bug-panel.component.html',
  styleUrl: './bug-panel.component.scss'
})
export class BugPanelComponent  implements OnInit {

  private modalService = inject(NgbModal);
  
  bugs: any = [];
  newBug: any = {};
  //bugInfo:any = {};
  modalReference:any;
  enableEdit: boolean = false;
  constructor(private _http: HttpClient) {}

  ngOnInit(): void {
    this.bugData();
    this.loadBugs();
  }
  bugData() {
    this._http.get('http://192.168.4.115:8081/api/bug').subscribe((response) => {
      this.bugs = response;
    })
  }
  loadBugs(): void {
    this._http.get<any[]>('http://192.168.4.115:8081/api/bug').subscribe(
      bugs => {
        this.bugs = bugs;
      },
      error => {
        console.error('Error loading bugs:', error);
      }
    );
  }

  submitBugForm(): void {
    // Handle form submission logic here
    console.log('Submitted bug:', this.newBug);
    // Assuming you have a backend endpoint to handle new bug creation
    if(this.enableEdit) {
      this.updateBug();
    } else {
      this.addBug();
    }
 
  }

  addBug(): void {
      
    this._http.post('http://192.168.4.115:8081/api/bug', this.newBug).subscribe(
      response => {
        console.log('Bug created successfully:', response);
        // Clear form and close modal after successful submission
        this.newBug = { description: '', status: '' };
        // Reload bugs data
        this.loadBugs();
        // Close modal
        document.getElementById('addBugModal')?.click(); // Simulate modal close
        this.modalReference?.close();
      },
      error => {
        console.error('Error creating bug:', error);
      }
    );
  }

  updateBug(): void{
      
    this._http.put(`http://192.168.4.115:8081/api/bug/${this.newBug.id}`, this.newBug).subscribe(
      response => {
        console.log('Bug created successfully:', response);
        // Clear form and close modal after successful submission
        this.newBug = { description: '', status: '' };
        // Reload bugs data
        this.loadBugs();
        // Close modal
        document.getElementById('addBugModal')?.click(); // Simulate modal close
        this.modalReference?.close();
      },
      error => {
        console.error('Error creating bug:', error);
      }
    );
  }


  deleteBug(id: number) {
    this._http.delete(`http://192.168.4.115:8081/api/bug/${id}`).subscribe({
      next: (response) => {
        console.log('Delete successful', response);
        // Refresh the bug data
        this.bugData();
      },
      error: (err) => {
        console.error('Error deleting bug', err);
      }
    });
  }

  openVerticallyCentered(content: TemplateRef<any>) {
		// this.modalService.open(content, { centered: true });
    this.modalReference =  this.modalService.open(content, { centered: true });
	}

  getbugDetails(id: number, content: TemplateRef<any>) {
    this._http.get(`http://192.168.4.115:8081/api/bug/${id}`).subscribe((response) => {
      console.log(' Update successful', response);
      this.newBug = response;
      this.enableEdit = true;
      this.openVerticallyCentered(content);
    }, err => {

    }
  )}


  close(): void {
    this.modalReference?.close();
    this.newBug = {};
  }
  

}
