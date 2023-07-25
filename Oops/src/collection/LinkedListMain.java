package collection;

class Node1 {
	Object element;
	Node1 next;

	public Node1(Object element, Node1 next) {
		this.element = element;
		this.next = next;
	}
}

class LinkedList {
	private Node1 first = null;
	// private Node1 last = null;
	private Integer count = 0;

	public void add(Object e) {
		if (first == null) {
			first = new Node1(e, null);
			count++;
			return;
		}
		Node1 curr = first;
		while (curr.next != null) {
			curr = curr.next;
		}
		curr.next = new Node1(e, null);
		count++;
	}

	public Integer size() {
		return count;
	}

	public void add(Integer index, Object e) {
		if (index <= -1 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		if (index == 0) {
			first = new Node1(e, first);
			count++;
			return;
		}
		Node1 curr = first;
		for (Integer i = 1; i < index; i++) {
			curr = curr.next;
		}
		Node1 n = new Node1(e, null);
		n.next = curr.next;
		curr.next = n;
		// curr.next=new Node(e,curr.next);
		count++;
	}

	public Object get(Integer index) {
		if (index <= -1 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		Node1 curr = first;
		for (Integer i = 1; i <= index; i++) {
			curr = curr.next;
		}
		return curr.element;
	}

	public void remove(Integer index) {
		if (index <= -1 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		if (index == 0) {
			first = first.next;
			count--;
			return;
		}
		Node1 curr = first;
		for (Integer i = 1; i < index; i++) {
			curr = curr.next;
		}
		curr.next = curr.next.next;
		count--;
	}

}

public class LinkedListMain {
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.add(15);
		l.add(25);
		l.add(35);
		l.add(45);
		l.add(55);
		for (Integer i = 0; i < l.size(); i++) {
			System.out.print(l.get(i) + " ");
		}
		System.out.println("\n------------------");

		l.add(2, 50);
		for (Integer i = 0; i < l.size(); i++) {
			System.out.print(l.get(i) + " ");
		}
		System.out.println("\n---------------");
		l.remove(0);
		for (Integer i = 0; i < l.size(); i++) {
			System.out.print(l.get(i) + " ");
		}
		System.out.println("\n-----------------");
		System.out.println(l.get(2));
		System.out.println("size : "+l.size());
	}

}
