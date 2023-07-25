package collection;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

public class PriorityQueue1 {
	public static void main(String[] args) {
		// Queue queue = new ArrayDeque();
		// Queue queue = new LinkedList();
		Queue<Integer> queue = new PriorityQueue<>();
		queue.add(51);
		queue.add(26);
		queue.add(19);
		queue.add(67);
		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}
}
