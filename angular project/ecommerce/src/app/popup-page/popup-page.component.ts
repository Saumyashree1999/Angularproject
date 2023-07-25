import { Component, OnInit} from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-popup-page',
  templateUrl: './popup-page.component.html',
  styleUrls: ['./popup-page.component.css']
})
export class PopupComponent implements OnInit{
  popupForm: FormGroup | any;
  errorMessage: String |any;
  successMessage: String |any;
  // dialogRef: any;


  constructor(private formBuilder: FormBuilder, private http: HttpClient, public dialogRef: MatDialogRef<PopupComponent>) { }

  ngOnInit() {
    this.popupForm = this.formBuilder.group({
      name: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]],
      email: ['', [Validators.required, Validators.email]],
      mobilenumber: ['', [Validators.required, Validators.pattern(/^\d{10}$/)]]
    });
  }


  onSubmit(): void {
    if (this.popupForm.invalid) {
      return;
    }

    const userData = this.popupForm.value;

    this.http.post('http://localhost:8080/subscriber/subscribe', userData).subscribe(
      response => {
        // API call success handling
        alert('Successfully Subscribed');
        this.dialogRef.close();
      },
      // error => {
      //   // API call error handling
      //   alert('Subscription failed');
      // }
    );
  }

  closePopup() {
     this.dialogRef.close();
  }

}

