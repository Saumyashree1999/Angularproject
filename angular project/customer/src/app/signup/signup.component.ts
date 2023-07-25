import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit{

  signupForm: FormGroup | any;
  errorMessage: string | any;
  successMessage: string | any;
  passwordMisMatch: boolean = false
  constructor(private formBuilder: FormBuilder, private http: HttpClient) {

  }
  ngOnInit(): void {
    this.signupForm = this.formBuilder.group({
      fullname: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
      confirmpassword: ['', Validators.required],
      mobileno: ['', [Validators.required, Validators.pattern(/^\d{10}$/)]]
    }
    );
  }
  passwordMatchValidator() {
    const password = this.signupForm.controls.password.value;
    const confirmpassword = this.signupForm.controls.confirmpassword.value;
    console.log(confirmpassword);
    console.log(password);

    if (password != confirmpassword) {
      this.passwordMisMatch = true;
      console.log(this.passwordMisMatch)


    } else {
      this.passwordMisMatch = false
    }
  }
  signup(): void {

    if (this.signupForm.invalid) {
      return;
    }
    this.passwordMatchValidator();
    if(this.passwordMisMatch){
      return;
    }

    const userData = this.signupForm.value;
    this.http.post('http://localhost:8080/customer/signup', userData).subscribe(
      response => {
        alert('Signup successful');
      },
      error => {
        alert('Signup failed');
      }
    );
  }
}

