package collection;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetmain {
	public static void main(String[] args) {

		SortedSet<Integer> sortedSet = new TreeSet<>();
		sortedSet.add(50);
		sortedSet.add(40);
		sortedSet.add(10);
		sortedSet.add(60);
		sortedSet.add(30);
		sortedSet.add(20);
		System.out.println(sortedSet.first());
		System.out.println(sortedSet.last());
		SortedSet<Integer> headSet = sortedSet.headSet(40);// 10,20,30
		display(headSet);
		SortedSet<Integer> tailSet = sortedSet.tailSet(40);// 40,50,60
		display(tailSet);
		SortedSet<Integer> subSet = sortedSet.subSet(20, 50);// 20,30,40
		display(subSet);
	}

	static void display(SortedSet s) {
		Iterator<Integer> iterator = s.iterator();
		while (iterator.hasNext())
			System.out.print(iterator.next() + " ");
		System.out.println();
	}

}
