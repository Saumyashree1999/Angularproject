package collection;

class Node {
	Object ele;
	Node next;

	public Node(Object e, Node n) {
		ele = e;
		next = n;
	}
}

class Stack {
	private Integer count = 0;
	private Node first = null;

	public void push(Object e) {
		if (first == null) {
			first = new Node(e, null);
			count++;
			return;
		}
		first = new Node(e, first);
		count++;
	}

	public Integer size() {
		return count;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public Object peek() {
		if (first == null)
			return null;
		return first.ele;
	}

	public Object pop() {
		if (first == null)
			return null;
		Object b = first.ele;
		first = first.next;
		count--;
		return b;
	}
}

public class StackMain {
	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(10);
		s.push(24);
		s.push(53);
		s.push(65);
		System.out.println("size : " + s.size());
		System.out.println(s.peek());
		while (!s.isEmpty()) {
			System.out.print(s.pop() + " ");
		}

	}
}
