package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author saumy
 *
 */
public class MapMain {
	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<>();
//		Map m = new LinkedHashMap();
		// Map m = new TreeMap();
		System.out.println(m.put("java", 68));
		System.out.println(m.put("html", 48));
		System.out.println(m.put("sql", 75));
		System.out.println(m.put("c", 80));
		Set s = m.keySet();
		Iterator i = s.iterator();
		while (i.hasNext()) {
			Object k = i.hasNext();
			Object v = m.get(k);
			System.out.println(k + " = " + v);
		}
	}
}
