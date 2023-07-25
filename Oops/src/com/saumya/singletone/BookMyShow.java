package com.saumya.singletone;

import java.util.Scanner;

class Theater {
	int seat = 10;

	private static Theater t = null;

	 private Theater() { }

	public static Theater getInstance() {
		if (t == null) {
			t = new Theater();
		}
		return t;
	}

	public void reserveSeat(int numseat) {
		if (numseat > seat) {
			System.out.println(numseat + " seats not available");
			System.out.println(seat + " seats are available");
			return;
		}
		seat = seat - numseat;
		System.out.println(numseat + " seats are reserved");
		System.out.println(seat + " seats are available");
	}
}

class BookingApp {
	public void bookTicket() {
		Scanner scn = new Scanner(System.in);
		System.out.println("TICKETS :");
		int ticket = scn.nextInt();

		if (ticket < 1)
			System.out.println("book atleast 1 ticket");
		else {
			//Theater theater = new Theater();
			//theater.getInstance().reserveSeat(ticket);
			
			 Theater theater = Theater.getInstance();
			theater.reserveSeat(ticket);
		}
	}
}

public class BookMyShow {

	public static void main(String[] args) {
		BookingApp customer1 = new BookingApp();
		customer1.bookTicket();

		BookingApp customer2 = new BookingApp();
		customer2.bookTicket();
		
		BookingApp customer3 = new BookingApp();
		customer3.bookTicket();
	}

}