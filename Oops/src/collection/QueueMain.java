package collection;

class Node3 {
	Object ele;
	Node3 next;

	public Node3(Object ele, Node3 next) {
		this.ele = ele;
		this.next = next;
	}
}

class Queue {
	private Node3 first = null;
	private Integer count = 0;

	public void add(Object e) {
		if (first == null) {
			first = new Node3(e, null);
			count++;
			return;
		}
		Node3 curr = first;
		while (curr.next != null) {
			curr = curr.next;
		}
		curr.next = new Node3(e, null);
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

	public Object pool() {
		if (first == null)
			return null;
		Object b = first.ele;
		first = first.next;
		count++;
		return b;
	}
}

public class QueueMain {
	public static void main(String[] args) {
		Queue q = new Queue();
		q.add(10);
		q.add(20);
		q.add(30);
		// System.out.println(q.pool());

		System.out.println(q.peek());
		System.out.println("------------------");
		// System.out.println("==================");
		// System.out.println(q.pool());
		while (!q.isEmpty()) {
			System.out.println(q.pool());
		}
		System.out.println(q.peek());

	}

}
