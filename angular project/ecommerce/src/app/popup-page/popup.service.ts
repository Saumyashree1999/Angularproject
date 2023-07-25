import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PopupService {
  private showPopupSubject: Subject<boolean> = new Subject<boolean>();

  showPopup$ = this.showPopupSubject.asObservable();

  setShowPopup(show: boolean) {
    this.showPopupSubject.next(show);
  }
}
