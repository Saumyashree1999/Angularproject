package collection;

import java.util.List;
import java.util.ArrayList;

public class Generic {
	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		//list.add(110);
		list.add("saumya");
		//list.add(120);
		

		List list2 = new ArrayList();
		list2.add(125);
		list2.add("hello");
		list2.add(12.24);
		//System.out.println((Integer)list2.get(0)+(Double)list2.get(2));
		//System.out.println(list2.get(0)+list2.get(2));

		System.out.println(list);
		System.out.println(list2);
	}
}
