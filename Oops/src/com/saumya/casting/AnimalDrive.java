package com.saumya.casting;

class Animal {
	public void drink() {
		System.out.println(" animals drink water");
	}

	public void sound() {
		System.out.println("animal sound");
	}

	public void eat() {
		System.out.println("animal eat");
	}

	public void color() {
		System.out.println("animal color");
	}
}

class Lion extends Animal {
	@Override
	public void sound() {
		System.out.println("Lions roar");
	}

	@Override
	public void eat() {
		System.out.println("Lions eat meat");
	}

//	public void hunt() {
//		System.out.println("Lion hunt");
//	}
}

public class AnimalDrive {
	public static void main(String[] args) {
		// UPCASTING
		Animal animal = new Lion();
		//animal.drink();
		animal.sound();
		animal.eat();
		//animal.color();
		// a1.hunt();//error- only override method of subclass are upcasted and all
		// method of super class can be accessed
//		System.out.println("--------------------------");
//	 DOWNCASTING
//		Lion lion = (Lion) animal;
//		lion.drink();
//		lion.sound();
//		lion.eat();
//		lion.color();
//		lion.hunt();
	}

}
