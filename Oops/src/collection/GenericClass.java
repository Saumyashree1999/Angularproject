package collection;

public class GenericClass {
	public static void main(String[] args) {

		A a = new A("saumya");
		A a1 = new A(15);
		A a2 = new A(12.5);
		System.out.println(a.getValue());
		System.out.println(a1.getValue());
		System.out.println(a2.getValue());

		// A<Integer> a3 = new A<Integer>(10);
		// a1.container="asd";
		// System.out.println(a3.getValue().getClass().getName());
		// A<String> a4 = new A("asdfg");
		// a4.getValue();
	}
}

class A<T> {
	Object container;
	// T container;

	public A(Object container) {
		super();
		this.container = container;
	}
//	public A(T container) {
//		super();
//		this.container = container;
//	}

	public Object getValue() {
		return this.container;
	}

}