package collection;

class Node2 {
	Object element;
	Node2 next;
	Node2 previous;

	public Node2(Object element) {
		this.element = element;
	}

	public Node2(Object element, Node2 next, Node2 previous) {
		this.element = element;
		this.next = next;
		this.previous = previous;
	}

}

class DoubleLinkedList {
	private Node2 first = null;
	private Integer count = 0;

	public void add(Object e) {
		if (first == null) {
			first = new Node2(e, null, null);
			count++;
			return;
		}
		Node2 curr = first;
		while (curr.next != null) {
			curr = curr.next;
		}
		curr.next = new Node2(e, null, curr);
		count++;
	}

	public Integer size() {
		return count;
	}

	public void add(Integer index, Object e) {
		if (index <= -1 || index >= size()) {
			throw new IndexOutOfBoundsException();
			//System.out.println("hggkjhvj");
		}
		if (index == 0) {
			first = new Node2(e, first, null);
			count++;
			return;
		}
		Node2 curr = first;
		for (Integer i = 1; i < index; i++) {
			curr = curr.next;
		}
		Node2 n = new Node2(e, null, null);
		n.next = curr.next;
		n.previous = curr;
		curr.next.previous = n;
		curr.next = n;
		count++;
	}

	public Object get(int index) {
		if (index <= -1 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		Node2 curr = first;
		for (Integer i = 1; i <= index; i++) {
			curr = curr.next;
		}
		return curr.element;
	}
}

public class DoubleLinkedListMain {
	public static void main(String[] args) {
		DoubleLinkedList d = new DoubleLinkedList();
		d.add(11);
		d.add(22);
		d.add(33);
		d.add(44);
		d.add(55);
		for (Integer i = 0; i < d.size(); i++) {
			System.out.print(d.get(i) + " ");
		}
		System.out.println("\n------------------");
		d.add(3, 50);
		for (Integer i = 0; i < d.size(); i++) {
			System.out.print(d.get(i) + " ");
		}

	}
}
