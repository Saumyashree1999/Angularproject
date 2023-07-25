package recursion;

public class Recursion2 {
	public Recursion2() {
		this(10);
	}

	public Recursion2(int i) {
		this();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Hello");
	}
}
//recursive method call is always runtime exception says that stack overflow error
//recursive constructor invokation is compile time error syntatctical mistake but not run time exception.