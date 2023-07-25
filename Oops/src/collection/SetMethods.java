package collection;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetMethods {
	public static void main(String[] args) {

		Set<Integer> set = new LinkedHashSet<Integer>();
		// boolean add(E e) - insert a new value to the set
		set.add(31);
		set.add(21);
		set.add(41);
		set.add(11);
		set.add(61);
		set.add(51);
		System.out.println("data: " + set);
		System.out.println("--------------------------");

		// boolean addAll(E e) - add all the elements of the specified collection to the
		// set.
		Set<Integer> set1 = new LinkedHashSet<Integer>();
		set1.add(91);
		set1.add(71);
		set1.add(81);
		set.addAll(set1);
		System.out.println(set);
		System.out.println("------------------");

		// void clear() - removes all the elements from the set
		// set.clear();
		System.out.println("final o/p : " + set);
		System.out.println("--------------------------");

		// boolean contains(E e) - used to know the presence of an element in the set
		System.out.println("Does the Set contains 51 ? : " + set.contains(51));
		System.out.println("------------------------");

		// boolean containsAll(Collection element) - used to check whether all the
		// elements of the collection are available in the existing set or not
		Set<Integer> set2 = new LinkedHashSet<Integer>();
		set2.add(31);
		set2.add(21);
		set2.add(41);
		System.out.println("\nDoes data contains all element ?: " + set.containsAll(set2));
		System.out.println("-------------------------------");

		// boolean isEmpty() - used to identify the emptiness of the set
		System.out.println("\nIs set empty?: " + set.isEmpty());
		System.out.println("-------------");

		// Iterator iterate = set1.iterator() - used to get the element one by one.
		Iterator<Integer> iterator = set.iterator();
		while (iterator.hasNext())
			System.out.println(iterator.next());
		System.out.println("-----------------");

		// boolean remove(Object O) - used to remove a specified element from the Set
		System.out.println(set.remove(41));
		set.remove(21);
		set.remove(11);
		System.out.println("data after removing elements: " + set);
		System.out.println("-------------------------");

		// boolean removeAll(Collection data) - removes all the elements of the existing
		// set from the specified collection

		set.removeAll(set1);
		System.out.println("data after removing  elements : " + set);
		System.out.println("---------------------");

		// int size() - returns the size of the set
		System.out.println("element present : " + set.size());
	}
}
