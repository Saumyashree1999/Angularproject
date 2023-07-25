package recursion;

public class Recursion1 {
	public static void m1() {
		m2();
	}

	public static void m2() {
		m1();
	}

	public static void main(String[] args) {
		//m1();//Exception in thread "main" java.lang.StackOverflowError
		System.out.println("Hello");
	}
}
