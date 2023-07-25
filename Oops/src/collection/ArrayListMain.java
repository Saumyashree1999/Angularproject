package collection;

class ArrayList {
	private Object[] a = new Object[5];
	private Integer p = 0;

	private void increase() {
		Object[] temp = new Object[a.length + 3];
		for (Integer i = 0; i < a.length; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}

	public void add(Object o) {
		if (p >= a.length)
			increase();
		a[p++] = o;
		//p++;
	}

	public void add(Integer index, Object e) {
		if (index <= -1 || index >= size())//
			throw new IndexOutOfBoundsException();
		if (p >= a.length)
			increase();
		for (Integer i = size() - 1; i >= index; i--) {
			a[i + 1] = a[i];
		}
		a[index] = e;
		p++;
	}

	public Integer size() {
		return p;
	}

	public Object get(int index) {
		if (index <= -1 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		return a[index];
	}

	public void remove(int index) {
		if (index <= -1 || index >= size())
			throw new IndexOutOfBoundsException();
		for (Integer i = index + 1; i < size(); i++) {
			a[i - 1] = a[i];
		}
		p--;
		a[p] = null;
	}

	public void clear() {
		a = new Object[5];
		p = 0;
	}

	@Override
	public String toString() {
		if (p == 0)
			return "[]";
		String s = "[" + a[0];
		for (Integer i = 1; i < size(); i++) {
			s = s + "," + a[i];
		}
		s += "]";
		return s;
	}
}

public class ArrayListMain {
	public static void main(String[] args) {
		ArrayList arrayList = new ArrayList();
		arrayList.add(10);
		arrayList.add(20);
		arrayList.add(30);
		System.out.println("size : " + arrayList.size());
		System.out.println(arrayList);
		System.out.println("--------------------");
		arrayList.add(1, 50);
		for (Integer i = 0; i < arrayList.size(); i++) {
			int x = (Integer) arrayList.get(i);
			System.out.print(x + " ");
		}
		System.out.println("\n--------------");
		System.out.println("size : " + arrayList.size());

		arrayList.remove(2);
		for (Integer i = 0; i < arrayList.size(); i++) {
			int x = (Integer) arrayList.get(i);
			System.out.print(x + " ");
		}
		System.out.println("\n--------------");
		// System.out.println("size : "+a.size());

		System.out.println(arrayList);
	}

}
