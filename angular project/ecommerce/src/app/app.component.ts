import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { PopupComponent } from './popup-page/popup-page.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title: any;
  dialogRef:any;
  constructor(private dialog: MatDialog) {}
  ngOnInit() {
    setTimeout(() => {
      this.openPopup();
    }, 2000);
  }


  openPopup(): void {
    const dialogRef: MatDialogRef<PopupComponent> = this.dialog.open(PopupComponent , {
      // width: '450px',
      // height: '350px'
    
  });
  
  
  dialogRef .afterClosed().subscribe((result: any) => {
      console.log('Popup closed', result);
    });
  }
}
