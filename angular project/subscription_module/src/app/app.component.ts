import { Component  } from '@angular/core';
// import { PopupComponent } from './popup-page/popup-page.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
  showAutoPopup = false;
  title: any;

  ngOnInit() {
    setTimeout(() => {
      this.showAutoPopup = true;
    }, 2000);
  }
  // constructor(private http: HttpClient) {}

  // submitForm(userData: any) {
  //   // Here you can integrate the API using the userData
  //   this.http.post('http://localhost:8080/subscriber/subscribe', userData).subscribe(
  //     (response) => {
  //       // console.log('API Response:', response);
  //       // Handle the success response here
  //       alert("successful");
  //     },
  //     (error) => {
  //       // console.error('API Error:', error);
  //       // Handle the error response here
  //       alert("failed");
  //     }
  //   );
  // }
}

