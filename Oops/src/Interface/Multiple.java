package Interface;

interface A {
	void m1();
}

interface B {
	void m1();
}

class C implements A, B {

	@Override
	public void m1() {
		System.out.println("class c");

	}

}

public class Multiple {

	public static void main(String[] args) {
		A a = new C();
		a.m1();
	}

}
