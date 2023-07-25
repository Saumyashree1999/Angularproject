package collection;

public class GenericMeyhod {
	public static  void printArray(Integer[] elements) {
		for (Integer e : elements) {
			System.out.print(e+" ");
		}
		System.out.println();
	}
//	public static <E> void printArray(E[] elements) {
//		for (E e : elements) {
//			System.out.print(e+" ");
//		}
//		System.out.println();
//	}

	public static void main(String args[]) {
		Integer[] integer = { 10, 20, 30 };
		Character[] character = { 'J', 'A', 'V', 'A' };

		System.out.println("Printing Integer Array");
		printArray(integer);

//		System.out.println("Printing Character Array");
//		printArray(character);
	}
}
