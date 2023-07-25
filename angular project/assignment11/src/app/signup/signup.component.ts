import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {

  name: string="";
  email: string="";
  password: string="";
  mobilenumber: string="";
  addressline1: string="";
  addressline2: string="";
  landmark: string="";
  city: string="";
  state: string="";
  country: string="";
  pincode: string="";


  constructor(private http: HttpClient){

  }

  save()
   {
      let bodyDate = {
      "name" : this.name,
      "email" : this.email,
      "password" : this.password,
      "mobilenumber" : this.mobilenumber,
      "addressline1" : this.addressline1,
      "addressline2" : this.addressline2,
      "landmark" : this.landmark,
      "city" : this.city,
      "state" : this.state,
      "country" : this.country,
      "pincode" : this.pincode
    };
    this.http.post("http://localhost:8080/designer/signup",bodyDate,{responseType: "text"}).subscribe((resultData: any)=>
    {
         console.log(resultData);
         alert("Customer Register Successfully");
    });
  }

}
