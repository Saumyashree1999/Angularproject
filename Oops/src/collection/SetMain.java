package collection;

import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class SetMain {
	public static void main(String[] args) {

		// Set<String> set = new HashSet<>();
		// Set<String> set = new LinkedHashSet<>();
		Set<String> set = new TreeSet<>();
		System.out.println(set.add("java"));
		System.out.println(set.add("c"));
		System.out.println(set.add("java"));
		System.out.println(set.add("sql"));
		System.out.println(set.add("python"));
		System.out.println(set.size());
//		Iterator iterator = set.iterator();
//		while (iterator.hasNext())
//			System.out.println(iterator.next());
		System.out.println("----------------------");
		for (Object o : set)
			System.out.println(o);
	}
}
