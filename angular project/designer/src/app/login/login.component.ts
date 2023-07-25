import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  loginForm: FormGroup | any;
  errorMessage: string | any;
  successMessage: string | any;
  passwordMisMatch: boolean = false
  constructor(private formBuilder: FormBuilder, private http: HttpClient) {

  }
  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
      confirmpassword: ['', Validators.required]
    }
    );
  }
  passwordMatchValidator() {
    const password = this.loginForm.controls.password.value;
    const confirmpassword = this.loginForm.controls.confirmpassword.value;
    console.log(confirmpassword);
    console.log(password);

    if (password != confirmpassword) {
      this.passwordMisMatch = true;
      console.log(this.passwordMisMatch)


    } else {
      this.passwordMisMatch = false
    }
  }
  login(): void {

    if (this.loginForm.invalid) {
      return;
    }
    this.passwordMatchValidator();
    if(this.passwordMisMatch){
      return;
    }

    const userData = this.loginForm.value;
    this.http.post('http://localhost:8080/designer/Login', userData).subscribe(
      response => {
        alert('Signup successful');
      },
      error => {
        alert('Signup failed');
      }
    );
  }
}
