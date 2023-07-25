import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
// import { ReactiveFormsModule } from '@angular/forms';
@Component({
  selector: 'app-popup-page',
  templateUrl: './popup-page.component.html',
  styleUrls: ['./popup-page.component.css']
})
export class PopupComponent implements OnInit{

  showPopup = true;
  popupForm: FormGroup | any;
  errrorMessage: String | any;
  successMessage: String |any;


  constructor(private formBuilder: FormBuilder, private http: HttpClient) {}
  ngOnInit(): void {
    
    this.popupForm = this.formBuilder.group({
      name: ['', [Validators.required, Validators.pattern('^.{3,20}$')]],
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
      (response) => {
        // console.log('API Response:', response);
        // Handle the success response here
        alert("successful");
        setTimeout(() => {
          // Handle successful response
          this.showPopup = false; // Hide the popup
        }, 2000);
      },
      (error) => {
        // console.error('API Error:', error);
        // Handle the error response here
        alert("failed");
      }
    );
    
  }
  closePopup() {
    this.showPopup = false;
    
  }
}